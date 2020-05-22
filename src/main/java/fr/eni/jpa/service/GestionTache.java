package fr.eni.jpa.service;

import fr.eni.jpa.bean.Tache;
import fr.eni.jpa.dao.GenericDao;
import fr.eni.jpa.dao.GenericDaoImpl;

import java.util.List;

public class GestionTache {

    GenericDao<Tache, Integer> dao;

    public GestionTache() {
        dao = new GenericDaoImpl<>();
    }

    public List<Tache> listeTaches() {
        return dao.findAll(Tache.class);
    }

    public Tache trouverTache(int id) {
        return dao.findById(Tache.class, id);
    }

    public void ajoutTache(Tache t) throws Exception {
        dao.add(t);
    }

    public void modifierTache(Tache t) throws Exception {
        dao.update(t);
    }

    public void supprimerTache(Tache t) throws Exception {
        dao.delete(t);
    }

    public void supprimerTache(int id) throws Exception {
        dao.delete(trouverTache(id));
    }

}
