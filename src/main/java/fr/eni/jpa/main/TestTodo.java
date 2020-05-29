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
        List<Tache> listTache = new ArrayList<>();
        List<Categorie> listCategorie = new ArrayList<>();

        GestionUtilisateur gu = new GestionUtilisateur();
        GestionCategorie gc = new GestionCategorie();
        GestionTache gt = new GestionTache();

        Utilisateur u1 = new Utilisateur("Royet", "Timothee", "Timpaddle", "azerty");
        Utilisateur u2 = new Utilisateur("Lecointre", "Remy", "SeasLiV", "qwerty", listTache, listCategorie);

        System.out.println("\nCréation des 2 users ...");

        try {
            gu.ajoutUtilisateur(u1);
            gu.ajoutUtilisateur(u2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        List<Utilisateur> liste = gu.listeUtilisateur();
        afficherUsers("Liste des users :", liste);

        try {
            gu.supprimerUtilisateur(u1);
        } catch (Exception e) {
            System.out.println("Echec lors de la suppression du user 1");
            System.out.println(e.getMessage());
        }
        u2.setIdConnexion("Mimosa");
        u2.setPassword("12345");
        try {
            gu.modifierUtilisateur(u2);
        } catch (Exception e) {
            System.out.println("Echec lors de la modification du user 2");
            System.out.println(e.getMessage());
        }

        afficherUsers("Liste apres CRUD :", gu.listeUtilisateur());


        System.out.println("");
        System.out.println(" ----- Catégories ----- ");
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

        System.out.println("Liste catégories : " + gc.listerCategories());

        c1.setLibelle("c1 updated");
        try {
            gc.modifierCategorie(c1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            gc.supprimerCategorie(c3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        listCategorie.add(c1);
        listCategorie.add(c2);

        System.out.println("Liste après CRUD:");
        System.out.println(gc.listerCategories());

        System.out.println(" ----- Tâche ----- ");

        Tache t1 = new Tache(new Date(), "Description de tache", false, listCategorie);
        Tache t2 = new Tache(new Date(), "Tache a delete", false, listCategorie);

        try {
            gt.ajoutTache(t1);
            gt.ajoutTache(t2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Liste tâches: " + gt.listerTaches());
        try {
            gt.supprimerTache(t2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        listTache.add(t1);
        try {
            gu.modifierUtilisateur(u2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Tache tacheToUpadte = gt.trouverTache(1);
        tacheToUpadte.setEtat(true);
        try {
            gt.modifierTache(tacheToUpadte);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Liste après taches et users après CRUD");
        System.out.println(gt.listerTaches());
        System.out.println(gu.listeUtilisateur());

    }

    private static void afficherUsers(String msg, List<Utilisateur> liste) {
        System.out.println();
        System.out.println(msg);
        for (Utilisateur utilisateur : liste) {
            System.out.println(utilisateur);
        }
    }
}
