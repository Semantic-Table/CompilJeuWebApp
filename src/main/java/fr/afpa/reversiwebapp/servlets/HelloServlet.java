package fr.afpa.reversiwebapp.servlets;

import fr.afpa.reversiwebapp.bo.PlateauDeJeu;
import fr.afpa.reversiwebapp.except.MissposeException;
import fr.afpa.reversiwebapp.except.OccupiedException;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/Jeu")
public class HelloServlet extends HttpServlet {
    private PlateauDeJeu plateau;

    public void init() {
        plateau = new PlateauDeJeu();


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd;
        if (request.getParameter("reset") != null) {
            this.init();
        }
        if (request.getParameter("x") != null && request.getParameter("y") != null) {
            try {
                plateau.setPlateau(Integer.parseInt(request.getParameter("x")), Integer.parseInt(request.getParameter("y")));
                plateau.autrePion();
            } catch (MissposeException ignored) {
                plateau.correction(Integer.parseInt(request.getParameter("x")), Integer.parseInt(request.getParameter("y")));
            } catch (OccupiedException e) {

            }
        }
        if (plateau.isTour()) {
            request.setAttribute("joueur", "C'est au tour des blancs");
        } else {
            request.setAttribute("joueur", "C'est au tour des noirs");
        }
        request.setAttribute("plateau", this.plateau.getPlateau());
        rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
        rd.forward(request, response);
    }

    public void destroy() {
    }
}