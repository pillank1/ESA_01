package com.ssau.tk.esa1.servlets;

import com.ssau.tk.esa1.ejb.AppBean;
import com.ssau.tk.esa1.model.Hero;
import com.ssau.tk.esa1.model.Player;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "MainPageServlet", value = "/MainPageServlet", urlPatterns = "/main")
public class MainPageServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Player> players = appBean.getAllPlayers();
        request.setAttribute("players", players);
        List<Hero> heroes = appBean.getAllHeroes();
        request.setAttribute("heroes", heroes);
        request.getRequestDispatcher("view/MainPage.jsp").forward(request, response);
    }
}
