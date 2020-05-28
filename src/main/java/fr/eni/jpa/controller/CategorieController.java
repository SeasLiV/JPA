package fr.eni.jpa.controller;

import fr.eni.jpa.bean.Categorie;
import fr.eni.jpa.service.GestionCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategorieController {

    @Autowired
    GestionCategorie gc;

    @RequestMapping(path = "/listerCategories", method = RequestMethod.GET)
    public ModelAndView listerCategories() {
        List<Categorie> listC = gc.listerCategories();
        Categorie cat = new Categorie();
        //TODO: if(listC.size() == 0) ajouter un attribut pour message liste catégorie vide
        ModelAndView mav = new ModelAndView("listeCategories", "listeC", listC);
        mav.getModelMap().addAttribute("cat", cat);
        return mav;
    }

    @RequestMapping(value = "/modifCategorie", method = RequestMethod.POST)
    public ModelAndView modifCategorie(Categorie c) {
        gc.modifierCategorie(c);
        return listerCategories();
    }

    @RequestMapping(value = "/ajouterCategorie", method = RequestMethod.POST)
    public ModelAndView ajouterCategorie(@Valid @ModelAttribute("cat") Categorie cat, BindingResult result) {
        if(result.hasErrors()) {
            return listerCategories();
        } else {
            gc.ajoutCategorie(cat);
            //TODO: placer le 2eme return ici et pointer vers la liste des tâches
        }
        return listerCategories();
    }

    @RequestMapping(value = "/supprimerCategorie", method = RequestMethod.GET)
    public ModelAndView supprimerCategorie(String index) {
        int i = Integer.parseInt(index.substring(1));
        gc.supprimerCategorie(i);
        return listerCategories();
    }

//    @RequestMapping(value = "/supprimerCategorie", method = RequestMethod.GET)
//    public ModelAndView supprimerCategorie(Categorie c) {
//        gc.supprimerCategorie(c);
//        return listerCategories();
//    }
}
