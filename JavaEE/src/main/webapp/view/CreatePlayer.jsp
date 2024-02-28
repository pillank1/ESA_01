<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create player</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<div class="container w-50">
    <form method="post" action="${pageContext.request.contextPath}/create-player">
        <h1>Create player</h1>
        <div class="form-group">
            <label for="firstName">Player first name: </label>
            <input class="form-control" id="firstName" name="firstName" type="text" required/>
        </div>
        <div class="form-group">
            <label for="lastName">Player last name: </label>
            <input class="form-control" id="lastName" name="lastName" type="text" required/>
        </div>
        <div class="form-group">
            <label for="birthdate">Birthday: </label>
            <input class="form-control" id="birthdate" name="birthdate" type="date" required/>
        </div>
        <div class="form-group">
            <label for="quantityGames">Quantity games: </label>
            <input class="form-control" id="quantityGames" name="quantityGames" type="number" min="0" max="20" required/>
            <div id="quantityGamesHelp" class="form-text">You can enter the quantity of games in the range from 0 to 20.</div>
        </div>
        <br>
        <input type="submit" value="Create" class="btn btn-success"/>
    </form>
</div>
</body>
</html>