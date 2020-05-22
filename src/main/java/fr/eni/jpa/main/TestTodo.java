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
        Utilisateur u1 = new Utilisateur("Royet", "Timothee", "Timpaddle", "azerty");
        Utilisateur u2 = new Utilisateur("Lecointre", "Remy", "SeasLiV", "qwerty");
//        Create / FindAll / Print / Edit / Delete / print


        GestionUtilisateur gestionUtilisateur = new GestionUtilisateur();
        System.out.println("\nCréation des 2 users ...");

        try {
            gestionUtilisateur.ajoutUtilisateur(u1);
            gestionUtilisateur.ajoutUtilisateur(u2);
            System.out.println("\nUsers are now here !");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<Utilisateur> liste = gestionUtilisateur.listeUtilisateur();

        afficherUsers("Liste des users :", liste);

        //suppression de u1
        try {
            gestionUtilisateur.supprimerUtilisateur(u1);
            System.out.println("User 1 supp");
        } catch (Exception e) {
            System.out.println("Echec lors de la suppression du user 1");
            System.out.println(e.getMessage());
        }
        // mise à jour de u2
        u2.setIdConnexion("Mimosa");
        u2.setPassword("12345");
        System.out.println("User 2 modifié");
        try {
            gestionUtilisateur.modifierUtilisateur(u2);
        } catch (Exception e) {
            System.out.println("Echec lors de la modification du user 2");
            System.out.println(e.getMessage());
        }

        afficherUsers("Liste des users apres suppression et modification :", gestionUtilisateur.listeUtilisateur());
    }

    private static void afficherUsers(String msg, List<Utilisateur> liste) {
        System.out.println();
        System.out.println(msg);
        for (Utilisateur utilisateur : liste) {
            System.out.println(utilisateur);

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
