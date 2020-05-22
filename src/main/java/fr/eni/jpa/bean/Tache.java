package fr.eni.jpa.bean;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private String description;
    private Boolean Etat;

    @ManyToMany
    @JoinTable(name = "TacheCategorie",
                joinColumns = {@JoinColumn(name = "tacheId")},
                inverseJoinColumns = {@JoinColumn(name = "categorieId")})
    private List<Categorie> categories;

    public Tache() {
    }

    public Tache(Date date, String description, Boolean etat, List<Categorie> categories) {
        this.date = date;
        this.description = description;
        Etat = etat;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEtat() {
        return Etat;
    }

    public void setEtat(Boolean etat) {
        Etat = etat;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }
}
