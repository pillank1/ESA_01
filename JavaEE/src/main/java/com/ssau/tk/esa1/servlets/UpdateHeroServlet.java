package com.ssau.tk.esa1.servlets;

import com.ssau.tk.esa1.ejb.AppBean;
import com.ssau.tk.esa1.model.Player;
import com.ssau.tk.esa1.model.Hero;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "UpdateHeroServlet", value = "/UpdateHeroServlet", urlPatterns = "/update-hero")
public class UpdateHeroServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long heroId = Long.parseLong(request.getParameter("heroId"));
        Hero hero = appBean.getHeroById(heroId);
        request.setAttribute("hero", hero);
        List<Long> playerIds = appBean.getAllPlayers().stream().map(Player::getId).collect(Collectors.toList());
        request.setAttribute("playerIds", playerIds);
        request.getRequestDispatcher("view/UpdateHero.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long heroId = Long.parseLong(request.getParameter("heroId"));
        String nameHero = request.getParameter("nameHero");
        Integer level = Integer.parseInt(request.getParameter("level"));
        String classHero = request.getParameter("classHero");
        Integer spellCells = Integer.parseInt(request.getParameter("spellCells"));
        Long playerId = Long.parseLong(request.getParameter("playerId"));
        appBean.updateHero(heroId, new Hero(nameHero, level, classHero, spellCells), playerId);
        response.sendRedirect(request.getContextPath() + "/main");
    }
}
