package fr.eni.jpa.service;

import fr.eni.jpa.bean.Categorie;
import fr.eni.jpa.dao.GenericDao;
import fr.eni.jpa.dao.GenericDaoImpl;

import java.util.List;

public class GestionCategorie {
    GenericDao<Categorie, Integer> dao;

    public GestionCategorie() {
        dao = new GenericDaoImpl<>();
    }

    public List<Categorie> listeCategorie() {
        return dao.findAll(Categorie.class);
    }

    public Categorie trouverCategorie(int id) {
        return dao.findById(Categorie.class, id);
    }


    public void ajoutCategorie(Categorie c) throws Exception {
        dao.add(c);
    }

    public void modifierCategorie(Categorie c) throws Exception {
        dao.update(c);
    }

    public void supprimerCategorie(Categorie c) throws Exception {
        dao.delete(c);
    }

    public void supprimerCategorie(int id) throws Exception {
        dao.delete(trouverCategorie(id));
    }

//    public List<Categorie> trier(String par) {
//        List<Categorie> liste = null;
//        liste = dao.findAll(Categorie.class);
//        return liste;
//    }
}
