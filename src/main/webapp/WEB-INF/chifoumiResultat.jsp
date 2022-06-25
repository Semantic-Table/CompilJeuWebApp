<%--
  Created by IntelliJ IDEA.
  User: stagiaire
  Date: 23/06/2022
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>COMBAT</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
<%
    String main = (String) request.getAttribute("main");
    String alea = (String) request.getAttribute("alea");
    String resultat = (String) request.getAttribute("resultat");
    String imgJ;
    String imgO;
%>
<%
    switch (main) {
        case "CHI":
            imgJ = "chi.png";
            break;
        case "FOU":
            imgJ = "fou.png";
            break;
        case "MI":
            imgJ = "mi.png";
            break;
        default:
            imgJ = "chi.png";
            break;
    }
    switch (alea) {
        case "CHI":
            imgO = "chi.png";
            break;
        case "FOU":
            imgO = "fou.png";
            break;
        case "MI":
            imgO = "mi.png";
            break;
        default:
            imgO = "chi.png";
            break;
    }

%>
<h1>------------ JEU DU CHIFOUMI ------------</h1>

<div class="jeu">
    <div class="image">
        <img src="img/<%= imgJ %> " alt="">
    </div>
    <div class="image">
        <img src="img/<%= imgO %> " alt="">
    </div>
</div>
<p>
<%=resultat%>
</p>
<p class="menu"><a href="Chifoumi"><button>==> REJOUER <== </button></a></p>

</body>
</html>
