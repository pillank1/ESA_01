package com.ssau.tk.esa1.servlets;

import com.ssau.tk.esa1.ejb.AppBean;
import com.ssau.tk.esa1.model.Player;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "UpdatePlayerServlet", value = "/UpdatePlayerServlet", urlPatterns = "/update-player")
public class UpdatePlayerServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long playerId = Long.parseLong(request.getParameter("playerId"));
        Player player = appBean.getPlayerById(playerId);
        request.setAttribute("player", player);
        request.getRequestDispatcher("view/UpdatePlayer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long playerId = Long.parseLong(request.getParameter("playerId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        LocalDate birthdate = LocalDate.parse(request.getParameter("birthdate"));
        Integer quantityGames = Integer.parseInt(request.getParameter("quantityGames"));
        appBean.updatePlayer(playerId, new Player(firstName, lastName, birthdate, quantityGames));
        response.sendRedirect(request.getContextPath() + "/main");
    }
}
