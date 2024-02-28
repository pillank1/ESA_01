<%@ page import="java.util.List" %>
<%@ page import="com.ssau.tk.esa1.model.Hero" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Update hero</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<%
  List<Long> playerIds = (List<Long>) request.getAttribute("playerIds");
  Hero hero = (Hero) request.getAttribute("hero");
%>
<div class="container w-50">
  <form method="post" action="${pageContext.request.contextPath}/update-hero">
    <h1>Update hero</h1>
    <input type="hidden" name="heroId" value="<%= hero.getId() %>">
    <div class="form-group">
      <label for="nameHero">Name hero: </label>
      <input class="form-control" id="nameHero" name="nameHero" type="text"
             value="<%= hero.getNameHero()%>" required/>
    </div>
    <div class="form-group">
      <label for="level">Level: </label>
      <input class="form-control" id="level" name="level" type="number" min="1" max="15"
             value="<%= hero.getLevel() %>" required/>
    </div>
    <div class="form-group">
      <label for="classHero">Class: </label>
      <select class="form-select" id="classHero" name="classHero" type="text" value="<%= hero.getClassHero() %>">
        <option selected><%= hero.getClassHero() %></option>
        <option value="Bard">Bard</option>
        <option value="Barbarian">Barbarian</option>
        <option value="Fighter">Fighter</option>
        <option value="Wizard">Wizard</option>
        <option value="Druid">Druid</option>
        <option value="Cleric">Cleric</option>
        <option value="Warlock">Warlock</option>
        <option value="Monk">Monk</option>
        <option value="Paladin">Paladin</option>
        <option value="Rogue">Rogue</option>
        <option value="Ranger">Ranger</option>
        <option value="Sorcerer">Sorcerer</option>
      </select>
    </div>
    <div class="form-group">
      <label for="spellCells">Spell cells: </label>
      <input class="form-control" id="spellCells" name="spellCells" type="number" min="0" max="10"
             value="<%= hero.getSpellCells() %>" required/>
      <div id="spellCellsHelp" class="form-text">You can enter spell cells in the range from 0 to 10.</div>
    </div>
    <div class="form-group">
      <label for="playerId">Player id: </label>
      <select class="form-control" id="playerId" name="playerId" required>
        <% for (Long playerId : playerIds) {%>
        <% if (playerId.equals(hero.getPlayer().getId())) {%>
        <option value="<%= playerId %>" selected><%= playerId %>
        </option>
        <% } else { %>
        <option value="<%= playerId %>"><%= playerId %>
        </option>
        <%
            }
          }
        %>
      </select>
    </div>
    <br>
    <input type="submit" value="Update" class="btn btn-warning"/>
  </form>
</div>
</body>
</html>