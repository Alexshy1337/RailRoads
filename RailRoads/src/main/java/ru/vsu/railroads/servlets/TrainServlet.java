package ru.vsu.railroads.servlets;

import ru.vsu.railroads.domain.Locomotive;
import ru.vsu.railroads.domain.Train;
import ru.vsu.railroads.domain.Wagon;
import ru.vsu.railroads.service.UniService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "TrainServlet", urlPatterns = "/train/*")
public class TrainServlet extends BaseServlet {
    UniService<Train> service;

    public void init(){ service = new UniService<>(Train.class); }

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Train> trains = service.readAll("");
        request.setAttribute("trains", trains);
        request.getRequestDispatcher("/WEB-INF/views/train/list.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/train/add.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("routeId", request.getParameter("routeId"));
        request.getRequestDispatcher("/WEB-INF/views/train/edit.jsp").forward(request, response);
    }

    public void addPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("routeId", request.getParameter("RouteId"));
        parameters.put("id", "NULL");
        service.create(parameters);
        response.sendRedirect("/RailRoads_war_exploded/train/list");
    }

    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("routeId", request.getParameter("RouteId"));
        service.update(id, parameters);
        response.sendRedirect("/RailRoads_war_exploded/train/list");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        service.delete(id);
        response.sendRedirect("/RailRoads_war_exploded/train/list");
    }

    public void trainInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UniService<Wagon> wagonService = new UniService<>(Wagon.class);
        UniService<Locomotive> locomotiveService = new UniService<>(Locomotive.class);
        Train train = service.readById(Long.parseLong(request.getParameter("id")));
        List<Wagon> wagons = wagonService.readAll(" where trainId="+train.getId());
        List<Locomotive> locomotives = locomotiveService.readAll(" where trainId="+train.getId());
        request.setAttribute("train", train);
        request.setAttribute("wagons", wagons);
        request.setAttribute("locomotives", locomotives);
        request.getRequestDispatcher("/WEB-INF/views/train/details.jsp").forward(request, response);

    }
}
