package fr.eni.jpa.controller;

import fr.eni.jpa.bean.Categorie;
import fr.eni.jpa.bean.Tache;
import fr.eni.jpa.service.GestionCategorie;
import fr.eni.jpa.service.GestionTache;
import fr.eni.jpa.service.GestionUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TacheController {

    @Autowired
    GestionCategorie gc;

    @Autowired
    GestionTache gt;

    @RequestMapping(path = "/listerTaches", method = RequestMethod.GET)
    public ModelAndView listerTaches() {
        List<Tache> listeT = gt.listerTaches();
        //TODO: if(listT.size() == 0) ajouter un attribut pour message liste Taches vide
        return new ModelAndView("listeTaches", "listeT", listeT);
    }

    @RequestMapping(path = "/ajouterTache", method = RequestMethod.GET)
    public ModelAndView ajouterTache(){
        Tache t = new Tache();
        ModelAndView mav = new ModelAndView("ajouterTache", "tache", t);
        List<Categorie> listeCategories = gc.listerCategories();
        mav.getModelMap().addAttribute("listeCategories", listeCategories);
        return mav;
    }

    @RequestMapping(value="/ajouterValid", method=RequestMethod.POST)
    public ModelAndView ajoutTacheValid(@Valid @ModelAttribute("tache") Tache tache, BindingResult result){
        System.out.println(tache);
        if(result.hasErrors()) {
            return ajouterTache();
        } else {
            gt.ajoutTache(tache);
        }
        return listerTaches();
    }

    @RequestMapping(value="/changerEtat", method=RequestMethod.GET)
    public ModelAndView changerEtat(String index){
        //TODO: Custom query plutôt que find + set + save ?
        int id = Integer.parseInt(index.substring(1));
        Tache tache = gt.trouverTache(id);
        tache.setEtat(!tache.getEtat());
        gt.modifierTache(tache);
        return listerTaches();
    }

    @RequestMapping(value = "/supprimerTache", method = RequestMethod.GET)
    public ModelAndView supprimerTache(String index) {
        int id = Integer.parseInt(index.substring(1));
        gt.supprimerTache(id);
        return listerTaches();
    }
}
