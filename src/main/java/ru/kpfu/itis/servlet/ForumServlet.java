package ru.kpfu.itis.servlet;

import lombok.SneakyThrows;
import ru.kpfu.itis.datasource.MySimpleDataSource;
import ru.kpfu.itis.models.Message;
import ru.kpfu.itis.repository.impl.BaseRepoMessages;
import ru.kpfu.itis.service.Service;

import javax.naming.InitialContext;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ForumServlet", value = "/buildings")
public class ForumServlet extends HttpServlet {
    private Service service;
    BaseRepoMessages repoMessages;

    @SneakyThrows
    @Override
    public void init(ServletConfig config) throws ServletException {
        InitialContext cxt = new InitialContext();
        DataSource ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/ArchitectureDB" );
        if ( ds == null ) {
            throw new Exception("Data source not found!");
        }
        repoMessages = new BaseRepoMessages(ds);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Message> messages = repoMessages.findAll();
        req.setAttribute("msgs", messages);
        ServletConfig config = getServletConfig();
        ServletContext context = config.getServletContext();
        context.getRequestDispatcher("/WEB-INF/jsp/ForumJSP.jsp").forward(req, resp);
    }
}
