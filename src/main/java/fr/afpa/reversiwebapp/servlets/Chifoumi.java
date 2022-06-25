package fr.afpa.reversiwebapp.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

@WebServlet("/Chifoumi")
public class Chifoumi extends HttpServlet {
    private String message;
    private final String nul = "MATCH NUL";
    private final String win = "GAGNE";
    private final String lose = "PERDU";
    private String resultat;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String main = request.getParameter("chifoumi");
        RequestDispatcher rd;

        request.setAttribute("main", main);
        Random rand = new Random();

        int alea = rand.nextInt(3);
        switch (alea) {
            case 0:
                request.setAttribute("alea", "CHI");
                break;
            case 1:
                request.setAttribute("alea", "FOU");
                break;
            case 2:
                request.setAttribute("alea", "MI");
                break;
        }
        try {
            if (!main.equals("") && main != null) {
                if (main.equals("CHI") || main.equals("FOU") || main.equals("MI")) {
                    switch (main) {
                        case "CHI":
                            combat(alea, nul, lose, win);
                            break;
                        case "FOU":
                            combat(alea, win, nul, lose);
                            break;
                        case "MI":
                            combat(alea, lose, win, nul);
                            break;
                    }
                    request.setAttribute("resultat", resultat);
                    rd = request.getRequestDispatcher("/WEB-INF/chifoumiResultat.jsp");
                    rd.forward(request, response);
                } else {
                    rd = request.getRequestDispatcher("/WEB-INF/chifoumiChoix.jsp");
                    rd.forward(request, response);
                }


            } else {
                rd = request.getRequestDispatcher("/WEB-INF/chifoumiChoix.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            rd = request.getRequestDispatcher("/WEB-INF/chifoumiChoix.jsp");
            rd.forward(request, response);
        }

    }

    private void combat(int alea, String nul, String lose, String win) {

        switch (alea) {
            case 0:
                resultat = nul;
                break;
            case 1:
                resultat = lose;
                break;
            case 2:
                resultat = win;
                break;
        }
    }

    public void destroy() {
    }
}
