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

    public List<Utilisateur> listeUtilisateur() {
        return dao.findAll();
    }

    public Utilisateur trouverUtilisateur(int id) {
        return dao.findOne(id);
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

    public Utilisateur login(String idConnexion, String password) {
        return dao.findByIdConnexionAndPassword(idConnexion, password);
    }
//    public List<Utilisateur> trier(String par) {
//        List<Utilisateur> liste = null;
//        liste = dao.findAll(Utilisateur.class);
//        return liste;
//    }
}
