package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")

public class JoueursController {
		
		@Autowired
		JoueurRepository j;
		@Autowired
		BoosterRepository b;
		
		@RequestMapping(value="/partie/{userId}/{score}/{tokens}",method = RequestMethod.POST)
	    public ResponseEntity<Void> partieController(@PathVariable(value="userId") long userId ,@PathVariable(value="tokens") long tokens,@PathVariable("score")long score){
			Joueur m3alem=j.findByJoueurId(userId);
			
	    	m3alem.setNbrParties(m3alem.getNbrParties()+1);
	    	m3alem.setCreditTokens(m3alem.getCreditTokens()+tokens);
	    	m3alem.setMeilleurScore(Math.max(m3alem.getMeilleurScore(),score));	
	    	return new ResponseEntity<Void>(HttpStatus.OK);
	    }
	    
	    
	    @RequestMapping(method=RequestMethod.POST,value="/create/{nom}")
	    public ResponseEntity<String> joueurController(@PathVariable(value="nom") String nomJoueur){
	    	Joueur m3alem = new Joueur(nomJoueur);
	    	j.save(m3alem);
	    	HttpHeaders responseHeaders = new HttpHeaders();
	    	   responseHeaders.set("MyResponseHeader", "MyValue");
	    	return new ResponseEntity<String>("DONE", responseHeaders, HttpStatus.CREATED);
	    }
	    
	    @RequestMapping(method=RequestMethod.GET,value="/classement/{userId}")
	    public ResponseEntity<Long> getClassement(@PathVariable("userId")long id){
	    	List<Joueur> lst = j.findAllByOrderByMeilleurScoreDesc();
	    	for(long i=0;i<lst.size();++i){
	    		Joueur m3alem=lst.get((int) i);
	    		if(m3alem.getJoueurId()==id)return new ResponseEntity<Long>(i+1,HttpStatus.OK);
	    	}
	    	return new ResponseEntity<Long>(-1L,HttpStatus.OK);
	    }
	    
	    /*@ExceptionHandler()
	    ResponseEntity<String>handleNotFounds(Exception e){
	    	HttpHeaders responseHeaders = new HttpHeaders();
	    	   responseHeaders.set("MyResponseHeader", "MyValue");
	    	return new ResponseEntity<String>(e.getStackTrace().toString(),responseHeaders,HttpStatus.NOT_FOUND);
	    }*/
	
}
