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
<div class="app reversi">
    <div class="titleReversiPage"><h1>&lt;jeu_du_reversi&gt;</h1></div>
    <div class="divReversi">
        <div class="board">
            <div class="joueur">
                <p>
                    <%=joueur%>
                </p>
            </div>
            <div class="scoreAndBoard">
                <div>
                    <p><%=scoreBlanc%>
                    </p>

                </div>


                <div class="table">
                    <table>
                        <%=plateau%>
                    </table>
                </div>
                <div>

                    <p><%=scoreNoir%>
                    </p>
                </div>
            </div>


        </div>

        <div>
            <p class="menu"><a href="Reversi?reset=true"><button>Reset</button></a>

                <a href="Accueil"><button>Accueil</button></a> </p>
        </div>




    </div>

</div>

</body>
</html>