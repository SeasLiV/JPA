package fr.eni.jpa.bean;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String libelle;

    @ManyToMany
    @JoinTable(name = "TacheCategorie",
            joinColumns = {@JoinColumn(name = "categorieId")},
            inverseJoinColumns = {@JoinColumn(name = "tacheId")})
    private List<Tache> taches;

    public Categorie() {
    }

    public Categorie(String libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

//    public List<Tache> getTaches() {
//        return taches;
//    }
//
//    public void setTaches(List<Tache> taches) {
//        this.taches = taches;
//    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
//                ", taches=" + taches +
                '}';
    }
}
