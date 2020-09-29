package ru.vsu.railroads.servlets;

import ru.vsu.railroads.domain.Locomotive;
import ru.vsu.railroads.domain.Route;
import ru.vsu.railroads.service.UniService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    public void add(){}
    public void delete(){}
    public void update(){}
}
