package fr.eni.jpa.main;

import fr.eni.jpa.bean.Categorie;
import fr.eni.jpa.bean.Tache;
import fr.eni.jpa.bean.Utilisateur;
import fr.eni.jpa.service.GestionCategorie;
import fr.eni.jpa.service.GestionTache;
import fr.eni.jpa.service.GestionUtilisateur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestTodo {
    public static void main(String[] args) {

        GestionUtilisateur gu = new GestionUtilisateur();
        GestionCategorie gc = new GestionCategorie();
        GestionTache gt = new GestionTache();

        List<Tache> listTache = new ArrayList<>();
        List<Categorie> listCategorie = new ArrayList<>();

        Utilisateur u1 = new Utilisateur("user1", "1resu", "pseudo1", "1234", listTache, listCategorie);
        try {
            gu.ajoutUtilisateur(u1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Categorie c1 = new Categorie("c1");
        Categorie c2 = new Categorie("c2");
        Categorie c3 = new Categorie("c3");

        try {
            gc.ajoutCategorie(c1);
            gc.ajoutCategorie(c2);
            gc.ajoutCategorie(c3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        listCategorie.add(c1);
        listCategorie.add(c2);

        Tache t1 = new Tache(new Date(), "Description de tache 1", false, listCategorie);
        listTache.add(t1);

        try {
            gt.ajoutTache(t1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            gu.modifierUtilisateur(u1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Tache tacheToUpadte = gt.trouverTache(1);
        tacheToUpadte.setetat(true);
        try {
            gt.modifierTache(tacheToUpadte);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
