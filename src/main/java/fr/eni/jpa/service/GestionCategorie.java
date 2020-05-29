package fr.eni.jpa.service;

import fr.eni.jpa.bean.Categorie;
import fr.eni.jpa.dao.CategorieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionCategorie {

    @Autowired
    CategorieDAO dao;

    //
    //TODO: catégories par rapport au user
    //
    public List<Categorie> listerCategories() {
        return dao.findAll();
    }

    public Categorie trouverCategorie(int id) {
        return dao.findOne(id);
    }


    public void ajoutCategorie(Categorie c) {
        dao.save(c);
    }

    public void modifierCategorie(Categorie c) {
        dao.save(c);
    }

    public void supprimerCategorie(Categorie c) {
        dao.delete(c);
    }

    public void supprimerCategorie(int id) {
        dao.delete(trouverCategorie(id));
    }
}
