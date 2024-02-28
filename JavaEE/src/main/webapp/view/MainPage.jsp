<%@ page import="java.util.List" %>
<%@ page import="com.ssau.tk.esa1.model.Player" %>
<%@ page import="com.ssau.tk.esa1.model.Hero" %>
<%@ page import="java.util.LinkedList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<% List<Player> players = (List<Player>) request.getAttribute("players"); %>
<% List<Hero> heroes = (List<Hero>) request.getAttribute("heroes"); %>
<div class="container">
    <br>
    <div class="text-center">
        <form action="${pageContext.request.contextPath}/create-player" method="get">
            <button class="btn btn-success">Create player</button>
        </form>
    </div>
    <table class="table table-striped table-primary">
        <caption style="caption-side: top">Players</caption>
        <thead>
        <tr>
            <th>Id</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Birthday</th>
            <th>Quantity games</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% for (Player player : players) { %>
        <tr>
            <td><%= player.getId() %>
            </td>
            <td><%= player.getFirstName() %>
            </td>
            <td><%= player.getLastName() %>
            </td>
            <td><%= player.getBirthdate() %>
            </td>
            <td><%= player.getQuantityGames() %>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/update-player">
                    <input type="hidden" name="playerId" value="<%= player.getId() %>">
                    <input type="submit" class="btn btn-warning" value="Update">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/delete-player" method="post">
                    <input type="hidden" name="playerId" value="<%= player.getId() %>">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <div class="text-center">
        <form action="${pageContext.request.contextPath}/create-hero" method="get">
            <button class="btn btn-success">Create hero</button>
        </form>
    </div>
    <table class="table table-striped table-success">
        <caption style="caption-side: top">Heroes</caption>
        <thead>
        <tr>
            <th>Id</th>
            <th>Name hero</th>
            <th>Level</th>
            <th>Class</th>
            <th>Spell cells</th>
            <th>Player Id</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% for (Hero hero : heroes) { %>
        <tr>
            <td><%= hero.getId() %>
            </td>
            <td><%= hero.getNameHero() %>
            </td>
            <td><%= hero.getLevel() %>
            </td>
            <td><%= hero.getClassHero() %>
            </td>
            <td><%= hero.getSpellCells() %>
            </td>
            <td><%= hero.getPlayer().getId() %>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/update-hero">
                    <input type="hidden" name="heroId" value="<%= hero.getId() %>">
                    <input type="submit" class="btn btn-warning" value="Update">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/delete-hero" method="post">
                    <input type="hidden" name="heroId" value="<%= hero.getId() %>">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <br>
    <figure class="text-center">
        <blockquote class="blockquote">
            <p>Если вы дадите человеку программу, то займете его на один день.<br> Если вы научите человека программировать,
                то займете его на всю жизнь.</p>
        </blockquote>
        <figcaption class="blockquote-footer">
            <cite title="Waseem Latif">Waseem Latif</cite>
        </figcaption>
    </figure>
</div>
</body>
</html>
