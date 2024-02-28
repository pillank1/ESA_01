package com.ssau.tk.esa1.servlets;

import com.ssau.tk.esa1.ejb.AppBean;
import com.ssau.tk.esa1.model.Player;
import com.ssau.tk.esa1.model.Hero;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "CreateHeroServlet", value = "/CreateHeroServlet", urlPatterns = "/create-hero")
public class CreateHeroServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Long> playerIds = appBean.getAllPlayers().stream().map(Player::getId).collect(Collectors.toList());
        request.setAttribute("playerIds", playerIds);
        request.getRequestDispatcher("view/CreateHero.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameHero = request.getParameter("nameHero");
        Integer level = Integer.parseInt(request.getParameter("level"));
        String classHero = request.getParameter("classHero");
        Integer spellCells = Integer.parseInt(request.getParameter("spellCells"));
        Long playerId = Long.parseLong(request.getParameter("playerId"));
        appBean.createHero(new Hero(nameHero, level, classHero, spellCells), playerId);
        response.sendRedirect(request.getContextPath() + "/main");
    }
}
