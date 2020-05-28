package fr.eni.jpa.dao;

import fr.eni.jpa.bean.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieDAO extends JpaRepository<Categorie, Integer> {
}
