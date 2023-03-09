package ru.kpfu.itis.servlet;

import ru.kpfu.itis.service.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServerServlet", value = "/server")
public class ServerServlet extends HttpServlet {
    private Service service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        service = (Service) getServletContext().getAttribute("service");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", "Some special name");
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/ServerJSP.jsp").forward(req, resp);
    }
}
