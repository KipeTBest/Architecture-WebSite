package ru.kpfu.itis.servlet;

import org.apache.taglibs.standard.tag.common.sql.DataSourceWrapper;
import ru.kpfu.itis.datasource.MySimpleDataSource;
import ru.kpfu.itis.models.UserModel;
import ru.kpfu.itis.repository.impl.BaseRepoMessages;
import ru.kpfu.itis.repository.impl.BaseRepoUsers;
import ru.kpfu.itis.service.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import javax.websocket.Session;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {
    private Service service;
    private BaseRepoUsers users;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        service = (Service) getServletContext().getAttribute("service");
        DataSource dataSource = new MySimpleDataSource("", "", "");
        users = new BaseRepoUsers(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserModel model = UserModel.builder().password(password).email(email).name(name).build();
        users.saveInfo(model);

        HttpSession session = req.getSession();
        session.setAttribute("user", model);

        req.setAttribute("name", "Some special name");
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/RegistrationJSP.jsp").forward(req, resp);
    }
}
