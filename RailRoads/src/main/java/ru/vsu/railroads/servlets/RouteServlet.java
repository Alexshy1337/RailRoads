package ru.vsu.railroads.servlets;

import ru.vsu.railroads.domain.Route;

import ru.vsu.railroads.domain.Wagon;
import ru.vsu.railroads.service.UniService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public void add(){}
    public void delete(){}
    public void update(){}

    public  void assignedTrains(){}
}
