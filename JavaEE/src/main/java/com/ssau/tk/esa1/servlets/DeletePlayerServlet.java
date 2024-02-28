package com.ssau.tk.esa1.servlets;

import com.ssau.tk.esa1.ejb.AppBean;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeletePlayerServlet", value = "/DeletePlayerServlet", urlPatterns = "/delete-player")
public class DeletePlayerServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long playerId = Long.parseLong(request.getParameter("playerId"));
        appBean.deletePlayer(playerId);
        response.sendRedirect(request.getContextPath() + "/main");
    }
}
