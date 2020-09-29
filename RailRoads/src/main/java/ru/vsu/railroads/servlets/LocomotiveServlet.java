package ru.vsu.railroads.servlets;

import ru.vsu.railroads.domain.Locomotive;
import ru.vsu.railroads.service.UniService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "LocomotiveServlet", urlPatterns = "/locomotive/*")
public class LocomotiveServlet extends BaseServlet {

    UniService<Locomotive> service;

    public void init(){ service = new UniService<>(Locomotive.class); }

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Locomotive> locomotives = service.readAll("");
        request.setAttribute("locomotives", locomotives);
        request.getRequestDispatcher("/WEB-INF/views/locomotive/list.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/locomotive/add.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("trainId", request.getParameter("trainId"));
        request.setAttribute("power", request.getParameter("power"));
        request.getRequestDispatcher("/WEB-INF/views/locomotive/edit.jsp").forward(request, response);
    }

    public void addPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("trainId", request.getParameter("trainId"));
        parameters.put("power", request.getParameter("power"));
        parameters.put("id", "NULL");
        service.create(parameters);
        response.sendRedirect("/RailRoads_war_exploded/locomotive/list");
    }

    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("power", request.getParameter("power"));
        parameters.put("trainId", request.getParameter("trainId"));
        service.update(id, parameters);
        response.sendRedirect("/RailRoads_war_exploded/locomotive/list");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        service.delete(id);
        response.sendRedirect("/RailRoads_war_exploded/locomotive/list");
    }
}
