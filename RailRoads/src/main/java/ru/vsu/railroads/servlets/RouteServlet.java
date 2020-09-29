package ru.vsu.railroads.servlets;

import ru.vsu.railroads.domain.Route;
import ru.vsu.railroads.service.UniService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "RouteServlet", urlPatterns = "/route/*")
public class RouteServlet extends BaseServlet {
    UniService<Route> service;

    public void init(){ service = new UniService<>(Route.class); }

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Route> routes = service.readAll("");
        request.setAttribute("routes", routes);
        request.getRequestDispatcher("/WEB-INF/views/route/list.jsp").forward(request, response);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/route/add.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("stations", request.getParameter("stations"));
        request.setAttribute("arrivalTime", request.getParameter("arrivalTime"));
        request.setAttribute("waitTime", request.getParameter("waitTime"));
        request.getRequestDispatcher("/WEB-INF/views/route/edit.jsp").forward(request, response);
    }

    public void addPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("stations", request.getParameter("stations"));
        parameters.put("arrivalTime", request.getParameter("arrivalTime"));
        parameters.put("waitTime", request.getParameter("waitTime"));
        parameters.put("id", "NULL");
        service.create(parameters);
        response.sendRedirect("/RailRoads_war_exploded/route/list");
    }

    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        HashMap<String, String> parameters = new HashMap<>();
        request.setAttribute("arrivalTime", request.getParameter("arrivalTime"));
        request.setAttribute("waitTime", request.getParameter("waitTime"));
        parameters.put("stations", request.getParameter("stations"));
        service.update(id, parameters);
        response.sendRedirect("/RailRoads_war_exploded/route/list");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        service.delete(id);
        response.sendRedirect("/RailRoads_war_exploded/route/list");
    }
    public  void assignedTrains(){}
}
