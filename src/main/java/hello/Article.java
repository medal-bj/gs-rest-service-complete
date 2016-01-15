package hello;

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
	private long articleId;
	
	private String nom;
	private long articlePrixGemmes;
	private long articlePrixTokens;

	private String Description;
	private String type;
	private String Icone;
    @ManyToMany(mappedBy="articles")
	List<Joueur> joueurs;
	
    public List<Joueur> getJoueurs(){return joueurs;}

	public Article(){//JPA
	}
	
	
	
	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setPrixTokens(long articlesPrixTokens) {
		this.articlePrixTokens = articlesPrixTokens;
	}

	public void setPrixGemmes(long prix){
		this.articlePrixGemmes =prix;
	}

	public void setDescription(String description) {
		Description = description;
	}


	public void setType(String type) {
		this.type = type;
	}


	public long getId() {
		return articleId;
	}
	public String getNom() {
		return nom;
	}

	public long getArticlePrixGemmes() {
		return articlePrixGemmes;
	}


	public void setArticlePrixGemmes(long articlePrixGemmes) {
		this.articlePrixGemmes = articlePrixGemmes;
	}


	public long getArticlePrixTokens() {
		return articlePrixTokens;
	}


	public void setArticlePrixTokens(long articlesPrixTokens) {
		this.articlePrixTokens = articlesPrixTokens;
	}


	public long getArticleId() {
		return articleId;
	}


	public String getDescription() {
		return Description;
	}
	public String getType() {
		return type;
	}
	public String getIcone() {
		return Icone;
	}
	
	@Override
	public String toString(){
		return "Article avec une ID : " + this.articleId+" de nom : "+this.nom;
	}
	
}
