package controllers;

import java.util.List;

//import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import controllers.JoueurRepository;
import data.Article;
import data.Booster;
import data.Joueur;

@RestController
public class BoutiqueController {

	    //private static final String template = "Hello, %s!";
	    //private final AtomicLong counter = new AtomicLong();
		JoueurRepository j;
		BoosterRepository b;
		ArticleRepository a;
	    @RequestMapping("/boutique/gemmes")
	    public void retirerGemmes(@RequestParam("id") long id,@RequestParam("gemmes") long gemmes){
	    	Joueur m3alem = j.findByJoueurId(id);
	    	m3alem.setCreditGemmes(m3alem.getCreditGemmes()-gemmes);
	    }
	    
	    @RequestMapping("/boutique/tokens")
	    public void retirerTokens(@RequestParam("id") long id,@RequestParam("tokens") long tokens){
	    	Joueur m3alem = j.findByJoueurId(id);
	    	m3alem.setCreditTokens(m3alem.getCreditTokens()-tokens);
	    }
	    
	    @RequestMapping("/boutique/boosts")
	    public void addBooster(@RequestParam("id") long id,@RequestParam("boosterId")long boosterId){
	    	Joueur m3alem = j.findByJoueurId(id);
	    	Booster boost =b.findByBoosterId(boosterId);
	    	List<Booster> boosters = m3alem.getBoosters();
	    	boosters.add(boost);
	    }
	    
	    
	    @RequestMapping("/boutique/articles")
	    public void addArticle(@RequestParam("id") long id,@RequestParam("articleId")long articleId){
	    	Joueur m3alem = j.findByJoueurId(id);
	    	Article art = a.findById(articleId);
	    	List<Article> articles = m3alem.getArticles();
	    	articles.add(art);
	    }
	    
	
}
