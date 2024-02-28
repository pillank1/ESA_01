<%@ page import="com.ssau.tk.esa1.model.Player" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Update player</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<% Player player = (Player) request.getAttribute("player"); %>
<div class="container w-50">
  <form method="post" action="${pageContext.request.contextPath}/update-player">
    <h1>Update player</h1>
    <input type="hidden" name="playerId" value="<%= player.getId() %>">
    <div class="form-group">
      <label for="firstName">First name: </label>
      <input class="form-control" id="firstName" name="firstName" type="text"
             value="<%= player.getFirstName() %>" required/>
    </div>
    <div class="form-group">
      <label for="lastName">Last name: </label>
      <input class="form-control" id="lastName" name="lastName" type="text"
             value="<%= player.getLastName() %>" required/>
    </div>
    <div class="form-group">
      <label for="birthdate">Birthday: </label>
      <input class="form-control" id="birthdate" name="birthdate" type="date"
             value="<%= player.getBirthdate() %>" required/>
    </div>
    <div class="form-group">
      <label for="quantityGames">Quantity games: </label>
      <input class="form-control" id="quantityGames" name="quantityGames" type="number" min="0" max="20"
             value="<%= player.getQuantityGames() %>" required/>
      <div id="quantityGamesHelp" class="form-text">You can enter the quantity of games in the range from 0 to 20.</div>
    </div>
    <br>
    <input type="submit" value="Update" class="btn btn-warning"/>
  </form>
</div>
</body>
</html>
