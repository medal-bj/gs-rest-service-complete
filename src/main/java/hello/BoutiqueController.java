package hello;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
//import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{userId}/boutique")
public class BoutiqueController {
		@Autowired
		JoueurRepository j;
		@Autowired
		BoosterRepository b;
		@Autowired
		ArticleRepository a;

		@RequestMapping(value="/deleteGemmes/{gemmes}",method = RequestMethod.POST)
	    public ResponseEntity<?> retirerGemmes(@PathVariable long userId,@RequestParam("gemmes") long gemmes){
	    	Joueur m3alem = j.findByJoueurId(userId);
	    	m3alem.setCreditGemmes(m3alem.getCreditGemmes()-gemmes);
	    	
	    	return new ResponseEntity<Void>(HttpStatus.CREATED);
	    }
		
		@RequestMapping(value = "/addGemmes/{gemmes}",method = RequestMethod.POST)
	    public ResponseEntity<?> ajouterGemmes(@PathVariable long userId,@RequestParam("gemmes") long gemmes){
	    	Joueur m3alem = j.findByJoueurId(userId);
	    	m3alem.setCreditGemmes(m3alem.getCreditGemmes()+gemmes);
	    	return new ResponseEntity<Void>(HttpStatus.CREATED);

	    }

		@RequestMapping(value = "/addTokens/{tokens}",method = RequestMethod.POST)
	    public ResponseEntity<?> ajouterTokens(@PathVariable long userId,@PathVariable("tokens") long tokens){
	    	Joueur m3alem = j.findByJoueurId(userId);
	    	m3alem.setCreditTokens(m3alem.getCreditTokens()+tokens);
	    	HttpHeaders responseHeaders = new HttpHeaders();
	    	   responseHeaders.set("MyResponseHeader", "MyValue");
	    	return new ResponseEntity<String>("", responseHeaders, HttpStatus.CREATED);
	    }
		
		@RequestMapping(value = "/deleteTokens/{tokens}",method = RequestMethod.POST)
	    public ResponseEntity<Void> retirerTokens(@PathVariable long userId,@PathVariable("tokens") long tokens){
	    	Joueur m3alem = j.findByJoueurId(userId);
	    	m3alem.setCreditTokens(m3alem.getCreditTokens()-tokens);
	    	return new ResponseEntity<Void>(HttpStatus.OK);
	    }
	    
		@RequestMapping(value = "/addBoost/{boosterId}",method = RequestMethod.POST)
	    public ResponseEntity<Void> addBooster(@PathVariable long userId,@PathVariable("boosterId")long boosterId){
	    	Joueur m3alem = j.findByJoueurId(userId);
	    	Booster boost =b.findByBoosterId(boosterId);
	    	List<Booster> boosters = m3alem.getBoosters();
	    	boosters.add(boost);
	    	return new ResponseEntity<Void>(HttpStatus.OK);

	    }
		
		@RequestMapping(value = "/deleteBoost/{boosterId}",method = RequestMethod.POST)
	    public ResponseEntity<Void> retirerBooster(@PathVariable long userId,@PathVariable("boosterId")long boosterId){
	    	Joueur m3alem = j.findByJoueurId(userId);
	    	Booster boost =b.findByBoosterId(boosterId);
	    	List<Booster> boosters = m3alem.getBoosters();
	    	boosters.remove(boost);
	    	return new ResponseEntity<Void>(HttpStatus.OK);

	    }
	    
	    
	    @RequestMapping(value="/{articleId}",method=RequestMethod.POST)
	    public ResponseEntity<Void> addArticleToJoueur(@PathVariable long userId,@PathVariable(value="articleId")long articleId){
	    	Joueur m3alem ;
	    	m3alem = j.findByJoueurId(userId);
	    	Article art = a.findByArticleId(articleId);
	    	List<Article> articles = m3alem.getArticles();
	    	articles.add(art);
	    	m3alem.setArticles(articles);
	    	return new ResponseEntity<Void>(HttpStatus.OK);
	    }
	    
	    @RequestMapping(value="/stock/{type}/{nom}/{articlePrixGemmes}/{articlePrixTokens}",method = RequestMethod.POST)
	    public ResponseEntity<Void> addArticle(@PathVariable(value="type")String type,@PathVariable(value="nom")String nom,@PathVariable(value="articlePrixGemmes")long articlePrixGemmes,@PathVariable(value="articlePrixTokens")long articlePrixTokens){
	    	Article art = new Article();
	    	art.setType(type);
	    	art.setNom(nom);
	    	art.setArticlePrixGemmes(articlePrixGemmes);
	    	art.setArticlePrixTokens(articlePrixTokens);

	    	a.save(art);
	    	return new ResponseEntity<Void>(HttpStatus.OK);

	    }
	
}
