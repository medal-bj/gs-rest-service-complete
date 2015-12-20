package controllers;

import java.util.List;

//import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import controllers.JoueurRepository;
import data.Booster;
import data.Joueur;

@RestController
public class PartieController {

	    //private static final String template = "Hello, %s!";
	    //private final AtomicLong counter = new AtomicLong();
		JoueurRepository j;
		BoosterRepository b;
	    @RequestMapping("/partie")
	    public void partieController(@RequestParam("id") long id,@RequestParam("gemmes") long gemmes,@RequestParam("tokens") long tokens,@RequestParam("booster")long boosterId){
	    	Joueur m3alem = j.findByJoueurId(id);
	    	Booster boost =b.findByBoosterId(boosterId);
	    	m3alem.setNbrParties(m3alem.getNbrParties()+1);
	    	List<Booster> boosters = m3alem.getBoosters();
	    	boosters.add(boost);
	    	m3alem.setBoosters(boosters);
	    	m3alem.setCreditGemmes(m3alem.getCreditGemmes()+gemmes);
	    	m3alem.setCreditTokens(m3alem.getCreditTokens()+tokens);
	    	
	    }
	    
	
}
