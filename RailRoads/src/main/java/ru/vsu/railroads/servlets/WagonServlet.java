package ru.vsu.railroads.servlets;

import ru.vsu.railroads.domain.Train;
import ru.vsu.railroads.domain.Wagon;
import ru.vsu.railroads.service.UniService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    public void add(){}
    public void delete(){}
    public void update(){}


}
