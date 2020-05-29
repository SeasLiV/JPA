package fr.eni.jpa.service;

import fr.eni.jpa.bean.Utilisateur;
import fr.eni.jpa.dao.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionUtilisateur {

    @Autowired
    UtilisateurDAO dao;
    Utilisateur loggedUser = new Utilisateur();

    public Utilisateur trouverUtilisateur(int id) {
        return dao.findOne(id);
    }

    public List<Utilisateur> listeUtilisateur() {
        return dao.findAll();
    }

    public void ajoutUtilisateur(Utilisateur u) {
        dao.save(u);
    }

    public void modifierUtilisateur(Utilisateur u) {
        dao.save(u);
    }

    public void supprimerUtilisateur(Utilisateur u) {
        dao.delete(u);
    }

    public void supprimerUtilisateur(int id) {
        dao.delete(trouverUtilisateur(id));
    }

    public Utilisateur getUserByLogin(Utilisateur utilisateur) {
        return dao.findByIdConnexion(utilisateur.getIdConnexion());
    }

    public Utilisateur getLoggedUser() {
        return this.loggedUser;
    }

    public void setLoggedUser(Utilisateur utilisateur) {
        this.loggedUser = utilisateur;
    }

    public void disconnectedUser() {
        this.loggedUser = new Utilisateur();
    }
}
