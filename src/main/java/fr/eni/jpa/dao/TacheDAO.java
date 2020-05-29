package fr.eni.jpa.dao;

import fr.eni.jpa.bean.Categorie;
import fr.eni.jpa.bean.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TacheDAO extends JpaRepository<Tache, Integer> {

    List<Tache> findByOrderByDateAsc();
    List<Tache> findByOrderByDateDesc();


    List<Tache> findAllByCategoriesIn(Categorie cat);
}
