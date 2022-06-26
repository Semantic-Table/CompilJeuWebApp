<%--
  Created by IntelliJ IDEA.
  User: marvi
  Date: 25/06/2022
  Time: 17:15
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
    <title>Accueil</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/anim.css">
</head>
<body>
<div class="app accueil">
    <div id="titleDiv"><h1>&lt;mini_games_compilation&gt; </h1></div>
    <div id="presentationDiv">
        <div class="vignette" id="vignetteChifoumi">
            <div class="titlePres" id="titleChifoumi">Game.chifoumi()</div>

            <div id="animCarte">

                <img class="imgPresCarte" id="imgChi" src="img/chi.png" alt="">
                <img class="imgPresCarte" id="imgFou" src="img/fou.png" alt="">
                <img class="imgPresCarte" id="imgMi" src="img/mi.png" alt="">
            </div>


            <div class="buttonDiv"><a href="Chifoumi">
                <button>Play.exe</button>
            </a></div>
        </div>
        <div class="vignette" id="vignetteReversi">
            <div class="titlePres" id="titleReversi">Game.reversi()</div>
            <div>
                <div>
                    <img class="imgPresRev" id="imgReversi" src="img/reversi.png" alt="">
                </div>

            </div>
            <div class="buttonDiv"><a href="Reversi">
                <button>Play.exe</button>
            </a></div>
        </div>
    </div>
</div>


</body>
</html>
