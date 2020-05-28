package fr.eni.jpa.servlet;

import fr.eni.jpa.bean.Utilisateur;
import fr.eni.jpa.service.GestionUtilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletLogin() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionUtilisateur gestionUtilisateur = new GestionUtilisateur();
        Utilisateur utilisateur = new Utilisateur();
        String idConnexion = request.getParameter("ÏdConnexion");
        String password = request.getParameter("Password");
        utilisateur = gestionUtilisateur.login(idConnexion, password);
        String bddPseudo = utilisateur.getIdConnexion();
        if (bddPseudo == null) {
            response.sendRedirect("loginFailed.jsp");
        } else {
            //Session part
            HttpSession session = request.getSession();
            session.setAttribute("utilisateur", utilisateur);
            session.setMaxInactiveInterval(10 * 60); //setting session to expiry in 10 min
            //Cookie part
            Cookie loginCookie = new Cookie("ÏdConnexion", idConnexion);
            loginCookie.setMaxAge(10 * 60); //setting cookie to expiry in 10 min
            response.addCookie(loginCookie);
            response.sendRedirect("loginSuccess.jsp");
        }
    }
}