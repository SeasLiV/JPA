package fr.eni.jpa.dao;

import fr.eni.jpa.bean.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDAO extends JpaRepository<Utilisateur, Integer> {
}
