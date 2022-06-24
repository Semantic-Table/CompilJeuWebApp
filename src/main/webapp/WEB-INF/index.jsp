<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<%!
    String plateau = "";
    String joueur = "";
%>
<%
    if (request.getAttribute("plateau") != null){
        plateau = (String) request.getAttribute("plateau");
    }
    if (request.getAttribute("joueur") != null) {
        joueur = (String) request.getAttribute("joueur");
    }


%>
<body>
<h1>Jeu du Reversi</h1>
<div>
<p><%=joueur%></p>
    <table>
        <%=plateau%>
    </table>
    <a href="Jeu?reset=true">cliquez pour jouer</a>

</div>
</body>
</html>