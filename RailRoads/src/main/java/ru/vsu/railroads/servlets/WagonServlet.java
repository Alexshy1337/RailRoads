package ru.vsu.railroads.servlets;

import ru.vsu.railroads.domain.Wagon;
import ru.vsu.railroads.service.UniService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "WagonServlet", urlPatterns = "/wagon/*")
public class WagonServlet extends BaseServlet {
    UniService<Wagon> service;

    public void init(){ service = new UniService<>(Wagon.class); }

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Wagon> wagons = service.readAll("");
        request.setAttribute("wagons", wagons);
        request.getRequestDispatcher("/WEB-INF/views/wagon/list.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/wagon/add.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("trainId", request.getParameter("trainId"));
        request.getRequestDispatcher("/WEB-INF/views/wagon/edit.jsp").forward(request, response);
    }

    public void addPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("trainId", request.getParameter("trainId"));
        parameters.put("id", "NULL");
        service.create(parameters);
        response.sendRedirect("/RailRoads_war_exploded/wagon/list");
    }

    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("trainId", request.getParameter("trainId"));
        service.update(id, parameters);
        response.sendRedirect("/RailRoads_war_exploded/wagon/list");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        service.delete(id);
        response.sendRedirect("/RailRoads_war_exploded/wagon/list");
    }

}
