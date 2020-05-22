package fr.eni.jpa.service;

import fr.eni.jpa.bean.Utilisateur;
import fr.eni.jpa.dao.GenericDao;
import fr.eni.jpa.dao.GenericDaoImpl;

import java.util.List;

public class GestionUtilisateur {

    GenericDao<Utilisateur, Integer> dao;

    public GestionUtilisateur() {
        dao = new GenericDaoImpl<>();
    }

    public List<Utilisateur> listeUtilisateur() {
        return dao.findAll(Utilisateur.class);
    }

    public Utilisateur trouverUtilisateur(int id) {
        return dao.findById(Utilisateur.class, id);
    }


    public void ajoutUtilisateur(Utilisateur u) throws Exception {
        dao.add(u);
    }

    public void modifierUtilisateur(Utilisateur u) throws Exception {
        dao.update(u);
    }

    public void supprimerUtilisateur(Utilisateur u) throws Exception {
        dao.delete(u);
    }

    public void supprimerUtilisateur(int id) throws Exception {
        dao.delete(trouverUtilisateur(id));
    }

    public List<Utilisateur> trier(String par) {
        List<Utilisateur> liste = null;
        liste = dao.findAll(Utilisateur.class);
        return liste;
    }
}
