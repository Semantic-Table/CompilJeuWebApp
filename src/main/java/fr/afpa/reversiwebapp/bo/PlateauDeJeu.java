package fr.afpa.reversiwebapp.bo;

import fr.afpa.reversiwebapp.except.MissposeException;
import fr.afpa.reversiwebapp.except.OccupiedException;

import java.util.Arrays;
import java.util.Objects;

public class PlateauDeJeu {
    private final String EMPTY = "<img class='case' src='img/empty.png'>";
    private final String WHITE = "<img class='case' src='img/white.png'>";
    private final String BLACK = "<img class='case' src='img/black.png'>";
    private String[][] plateau = new String[8][8];
    private int nbTours;
    private int blanc;
    private int noir;
    private boolean tour;

    public PlateauDeJeu() {
        nbTours = 59;
        for (String[] cs : plateau) {
            Arrays.fill(cs, EMPTY);
        }
        plateau[3][4] = WHITE;
        plateau[4][3] = WHITE;
        plateau[3][3] = BLACK;
        plateau[4][4] = BLACK;
    }

    public void afficherPlateau() {
        System.out.print("  ");
        for (int i = 0; i < plateau.length; i++) {
            System.out.print(i + 1 + " ");

        }
        System.out.println();
        for (int i = 0; i < plateau.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < plateau.length; j++) {
                System.out.print(plateau[i][j] + " ");
            }
            System.out.println();
        }
    }

    public  int scoreBlanc(){
        this.blanc = 0;
        for (String[] cs: plateau) {
            for (String c: cs) {
                if (Objects.equals(c, WHITE)){
                    this.blanc++;
                }
            }
        }
        return this.blanc;
    }

    public int scoreNoir(){
        this.noir = 0;
        for (String[] cs: plateau) {
            for (String c: cs) {
                if (Objects.equals(c, BLACK)){
                    this.noir++;
                }
            }
        }
        return this.noir;
    }


    public void setPlateau(int x, int y) throws MissposeException, OccupiedException {
        String couleur;
        if (this.tour) {
            couleur = BLACK;
        } else {
            couleur = WHITE;
        }
        if (plateau[y][x] == EMPTY) {
            plateau[y][x] = couleur;
            this.miseAJour(x, y);
        } else {
            throw new OccupiedException("La place est deja prise !");
        }


    }

    public void correction(int x, int y) {
        plateau[y][x] = EMPTY;
    }

    public void autrePion() {
        tour = !tour;
    }

    public void miseAJour(int x, int y) throws MissposeException {

        boolean trou = false;
        boolean ami = false;
        boolean reussite = false;
        int xi = x;
        int yi = y;
        int cptnmy = 0;
        // droite
        try {
            while (!trou && !ami) {
                xi++;
                if (this.plateau[yi][xi] == EMPTY) {
                    trou = true;
                } else if (this.plateau[yi][xi] == this.plateau[y][x]) {
                    ami = true;
                } else {
                    cptnmy++;
                }

            }
            if (ami && !trou && cptnmy > 0) {
                reussite = true;
                for (int i = x; i < xi; i++) {
                    this.plateau[y][i] = this.plateau[y][x];
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

        // gauche

        trou = false;
        ami = false;
        xi = x;
        yi = y;
        cptnmy = 0;
        try {
            while (!trou && !ami) {
                xi--;
                if (this.plateau[yi][xi] == EMPTY) {
                    trou = true;
                } else if (this.plateau[yi][xi] == this.plateau[y][x]) {
                    ami = true;
                } else {
                    cptnmy++;
                }

            }
            if (ami && !trou && cptnmy > 0) {
                reussite = true;
                for (int i = x; i > xi; i--) {
                    this.plateau[y][i] = this.plateau[y][x];
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        // bas
        trou = false;
        ami = false;
        xi = x;
        yi = y;
        cptnmy = 0;
        try {
            while (!trou && !ami) {
                yi++;
                if (this.plateau[yi][xi] == EMPTY) {
                    trou = true;
                } else if (this.plateau[yi][xi] == this.plateau[y][x]) {
                    ami = true;
                } else {
                    cptnmy++;
                }

            }
            if (ami && !trou && cptnmy > 0) {
                reussite = true;
                for (int i = y; i < yi; i++) {
                    this.plateau[i][x] = this.plateau[y][x];
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        // haut
        trou = false;
        ami = false;
        xi = x;
        yi = y;
        cptnmy = 0;
        try {
            while (!trou && !ami) {
                yi--;
                if (this.plateau[yi][xi] == EMPTY) {
                    trou = true;
                } else if (this.plateau[yi][xi] == this.plateau[y][x]) {
                    ami = true;
                } else {
                    cptnmy++;
                }

            }
            if (ami && !trou && cptnmy > 0) {
                reussite = true;
                for (int i = y; i > yi; i--) {
                    this.plateau[i][x] = this.plateau[y][x];
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        // haut-gauche
        trou = false;
        ami = false;
        xi = x;
        yi = y;
        int cpt = 0;
        cptnmy = 0;
        try {
            while (!trou && !ami) {
                yi--;
                xi--;
                if (this.plateau[yi][xi] == EMPTY) {
                    trou = true;
                } else if (this.plateau[yi][xi] == this.plateau[y][x]) {
                    ami = true;
                } else {
                    cptnmy++;
                }

            }
            if (ami && !trou && cptnmy > 0) {
                reussite = true;
                for (int i = y; i > yi; i--) {
                    this.plateau[i][x + cpt] = this.plateau[yi][xi];
                    cpt--;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        // haut-droite
        trou = false;
        ami = false;
        xi = x;
        yi = y;
        cpt = 0;
        cptnmy = 0;
        try {
            while (!trou && !ami) {
                yi--;
                xi++;
                if (this.plateau[yi][xi] == EMPTY) {
                    trou = true;
                } else if (this.plateau[yi][xi] == this.plateau[y][x]) {
                    ami = true;
                } else {
                    cptnmy++;
                }

            }
            if (ami && !trou && cptnmy > 0) {
                reussite = true;
                for (int i = y; i > yi; i--) {
                    this.plateau[i][x + cpt] = this.plateau[y][x];
                    cpt++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        // bas-droit
        trou = false;
        ami = false;
        xi = x;
        yi = y;
        cpt = 0;
        cptnmy = 0;
        try {
            while (!trou && !ami) {
                yi++;
                xi++;
                if (this.plateau[yi][xi] == EMPTY) {
                    trou = true;
                } else if (this.plateau[yi][xi] == this.plateau[y][x]) {
                    ami = true;
                } else {
                    cptnmy++;
                }

            }
            if (ami && !trou && cptnmy > 0) {
                reussite = true;
                for (int i = y; i < yi; i++) {
                    this.plateau[i][x + cpt] = this.plateau[y][x];
                    cpt++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        // bas-gauche
        trou = false;
        ami = false;
        xi = x;
        yi = y;
        cpt = 0;
        cptnmy = 0;
        try {
            while (!trou && !ami) {
                yi++;
                xi--;
                if (this.plateau[yi][xi] == EMPTY) {
                    trou = true;
                } else if (this.plateau[yi][xi] == this.plateau[y][x]) {
                    ami = true;
                } else {
                    cptnmy++;
                }

            }
            if (ami == true && trou == false && cptnmy > 0) {
                reussite = true;
                for (int i = y; i < yi; i++) {
                    this.plateau[i][x + cpt] = this.plateau[y][x];
                    cpt--;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        if (!reussite) {
            throw new MissposeException("La case n'est pas valide, réessayez.");
        }

    }

    // getter/setter
    public String getPlateau() {
        String affPlateau = "";

        for (int i = 0; i < this.plateau.length; i++) {
            affPlateau += "<tr>";
            for (int j = 0; j < this.plateau.length; j++) {
                affPlateau += "<td><a href='Reversi?x="+j+"&y="+i+"'>"+ this.plateau[i][j] +"</a></td>";
             }
            affPlateau += "</tr>";
        }

        return affPlateau;
    }

    public void setPlateau(String[][] plateau) {
        this.plateau = plateau;
    }

    public int getNbTours() {
        return nbTours;
    }

    public void setNbTours(int nbTours) {
        this.nbTours = nbTours;
    }

    public int getBlanc() {
        return blanc;
    }

    public void setBlanc(int blanc) {
        this.blanc = blanc;
    }

    public int getNoir() {
        return noir;
    }

    public void setNoir(int noir) {
        this.noir = noir;
    }

    public boolean isTour() {
        return tour;
    }

    public void setTour(boolean tour) {
        this.tour = tour;
    }
}
