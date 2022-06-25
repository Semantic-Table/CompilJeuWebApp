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
    String scoreBlanc = "";
    String scoreNoir = "";
%>
<%
    if (request.getAttribute("plateau") != null) {
        plateau = (String) request.getAttribute("plateau");
    }
    if (request.getAttribute("joueur") != null) {
        joueur = (String) request.getAttribute("joueur");
    }
    if (request.getAttribute("scoreBlanc") != null) {
        scoreBlanc = "Score des blanc : " + (int) request.getAttribute("scoreBlanc");
    }
    if (request.getAttribute("scoreNoir") != null) {
        scoreNoir = "Score des noir : " + (int) request.getAttribute("scoreNoir");
    }


%>
<body>
<h1>Jeu du Reversi</h1>
<div>
    <p><%=joueur%>
    </p>
    <p><%=scoreBlanc%>
    </p>
    <p><%=scoreNoir%>
    </p>
</div>


<div>
    <table>
        <%=plateau%>
    </table>
    <p class="menu"><button><a href="Reversi?reset=true">==> reset de la planche <==</a> </button>

        <a href="Accueil"><button>==> Retour a l'accueil <==</button></a> </p>


</div>
</body>
</html>