package data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ArticleId;
	
	private String Nom;
	private long prix;
	private double devise;
	private String Description;
	private String Type;
	private String Icone;
	List<Joueur> joueurs;
	
    @ManyToMany(mappedBy="articles")
    public List<Joueur> getJoueurs(){return joueurs;}

	
	public long getId() {
		return ArticleId;
	}
	public String getNom() {
		return Nom;
	}
	public long getPrix() {
		return prix;
	}
	public double getDevise() {
		return devise;
	}
	public String getDescription() {
		return Description;
	}
	public String getType() {
		return Type;
	}
	public String getIcone() {
		return Icone;
	}
	

	
}
