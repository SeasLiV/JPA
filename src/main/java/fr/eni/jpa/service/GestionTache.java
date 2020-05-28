package fr.eni.jpa.service;

import fr.eni.jpa.bean.Categorie;
import fr.eni.jpa.bean.Tache;
import fr.eni.jpa.dao.TacheDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionTache {

    @Autowired
    TacheDAO dao;

    public List<Tache> listeTaches() {
        return dao.findAll();
    }

    public Tache trouverTache(int id) {
        return dao.findOne(id);
    }

    public void ajoutTache(Tache t) {
        dao.save(t);
    }

    public void modifierTache(Tache t) {
        dao.save(t);
    }

    public void supprimerTache(Tache t) {
        dao.delete(t);
    }

    public void supprimerTache(int id) {
        dao.delete(trouverTache(id));
    }

    public List<Tache> trier(String par, Categorie cat) {
        List<Tache> liste = null;

        switch (par) {
            case "dateAsc": liste = dao.findByOrderByDateAsc();
            break;
            case "dateDesc": liste = dao.findByOrderByDateDesc();
            break;
            case "cat": liste = dao.findAllByCategoriesIn(cat);
            default: liste = dao.findAll();
        }
        return liste;
    }

}
