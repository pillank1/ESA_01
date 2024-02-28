package com.ssau.tk.esa1.servlets;

import com.ssau.tk.esa1.ejb.AppBean;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteHeroServlet", value = "/DeleteHeroServlet", urlPatterns = "/delete-hero")
public class DeleteHeroServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long heroId = Long.parseLong(request.getParameter("heroId"));
        appBean.deleteHero(heroId);
        response.sendRedirect(request.getContextPath() + "/main");
    }
}
