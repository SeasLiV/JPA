package fr.eni.jpa.bean;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date date;

    private String description;
    private Boolean etat;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "TacheCategorie",
                joinColumns = {@JoinColumn(name = "tacheId")},
                inverseJoinColumns = {@JoinColumn(name = "categorieId")})
    private List<Categorie> categories;

    public Tache() {
        this.etat = false;
    }

    public Tache(Date date, String description, Boolean etat, List<Categorie> categories) {
        this.date = date;
        this.description = description;
        this.etat = etat;
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
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", etat=" + etat +
                ", categories=" + categories +
                '}';
    }
}
