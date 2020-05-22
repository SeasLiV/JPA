package fr.eni.jpa.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String idConnexion;
	private String password;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Tache> taches;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Categorie> categories;

	public Utilisateur() {
	}

	public Utilisateur(String nom, String prenom, String idConnexion, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.idConnexion = idConnexion;
		this.password = password;
	}

	public Utilisateur(String nom, String prenom, String idConnexion, String password, List<Tache> taches, List<Categorie> categories) {
		this.nom = nom;
		this.prenom = prenom;
		this.idConnexion = idConnexion;
		this.password = password;
		this.taches = taches;
		this.categories = categories;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getIdConnexion() {
		return idConnexion;
	}

	public void setIdConnexion(String idConnexion) {
		this.idConnexion = idConnexion;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Utilisateur{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", idConnexion='" + idConnexion + '\'' +
				", password='" + password + '\'' +
				", taches=" + taches +
				", categories=" + categories +
				'}';
	}
}
