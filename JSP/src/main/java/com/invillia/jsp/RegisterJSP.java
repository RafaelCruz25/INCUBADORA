package com.invillia.jsp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterJSP extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("name", req.getParameter("nome"));
        req.setAttribute("email", req.getParameter("email"));
        req.setAttribute("adress", req.getParameter("endereco"));

        final RequestDispatcher requestDispatcher = req.getRequestDispatcher("/sucess.jsp");
        requestDispatcher.forward(req,resp);

    }
}
