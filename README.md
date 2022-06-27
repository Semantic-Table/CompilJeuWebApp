# Jeu du reversi et du chifoumi sous forme d'application web

---

Serveur : tomcat 9

SDK : 11

---

## Page index :

![Index](src/main/webapp/img/AccueilScreen.png)
Page d'accueil de l'application, choix entre les deux jeu Reversi ou Chifoumi.

## Jeu du chifoumi : 

![Chifoumi](src/main/webapp/img/ChifoumiScreen.png)

Ecran de choix pour le Chifoumi, le parametre sera envoyer a la page suivante.

![Resultat](src/main/webapp/img/ResultatScreen.png)

Ecran du résultat, la servlet compare le paramatre reçu avec le choix pseudo 
aleatoire qu'elle a fait et renvoie le résultat de la comparaison a cette page.

## Jeu du reversi :

![Reversi](src/main/webapp/img/ReversiScreen.png)

Ecran du jeu Reversi, ce joue a 2 joueurs, les blancs commence, il suffit de 
cliquer sur la case que l'on souhaite occupé, si cela est possible le jeu est 
mis à jour, sinon on doit réessayer.