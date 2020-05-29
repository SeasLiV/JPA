package fr.eni.jpa.controller;

import fr.eni.jpa.bean.Utilisateur;
import fr.eni.jpa.service.GestionUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller
//@SessionAttributes({"loggedUser"})
@SessionAttributes(value = "loggedUser", types = {Utilisateur.class})
public class LoginController {

    @Autowired
    GestionUtilisateur gestionUtilisateur;

    @PostConstruct
    private void init() {
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        Utilisateur utilisateur = new Utilisateur();
        return new ModelAndView("login", "command", utilisateur);
    }

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public ModelAndView loginCheck(Utilisateur utilisateur) {
        Utilisateur user = gestionUtilisateur.getUserByLogin(utilisateur);
        if (user == null) {
            return login();
        } else if (user.getPassword().compareTo(utilisateur.getPassword()) == 0) {
            gestionUtilisateur.setLoggedUser(user);
            return new ModelAndView("listeTaches");
        } else {
            return login();
        }
    }

    @ModelAttribute("loggedUser")
    public Utilisateur getLoggedUser() {
        return gestionUtilisateur.getLoggedUser();
    }
}