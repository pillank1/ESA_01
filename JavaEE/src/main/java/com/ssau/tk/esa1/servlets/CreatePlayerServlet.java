package com.ssau.tk.esa1.servlets;
import com.ssau.tk.esa1.ejb.AppBean;
import com.ssau.tk.esa1.model.Player;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "CreatePlayerServlet", value = "/CreatePlayerServlet", urlPatterns = "/create-player")
public class CreatePlayerServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/CreatePlayer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        LocalDate birthdate = LocalDate.parse(request.getParameter("birthdate"));
        Integer quantityGames = Integer.parseInt(request.getParameter("quantityGames"));
        appBean.createPlayer(new Player(firstName, lastName, birthdate, quantityGames));
        response.sendRedirect(request.getContextPath() + "/main");
    }
}