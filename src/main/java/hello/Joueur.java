package hello;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity

public class Joueur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long joueurId;
	private long meilleurScore;
	private Date derniereConnexion;
	private long creditGemmes;
	private long creditTokens;
	private String nom;
	@ManyToMany
	  @JoinTable(name="Achat")
	private List<Article>articles;
	
	@ManyToMany
	  @JoinTable(name="DefisAcheves")
	private List<Defi> defis;
	 @ManyToMany
	  @JoinTable(name="Boosters")
	private List<Booster> boosters;
	
	private long nbrParties;

	protected Joueur(){}
	public Joueur (String nom){
		this.nom=nom;
		this.meilleurScore=0;
		this.derniereConnexion=new Date();
		this.creditGemmes=0;
		this.creditTokens=0;
	}
	
	public void setNom(String nom){
		this.nom=nom;
	}
	public String getNom(){
		return this.nom;
	}
	public long getCreditGemmes() {
		return creditGemmes;
	}

	public void setCreditGemmes(long creditGemmes) {
		this.creditGemmes = creditGemmes;
	}

	public long getCreditTokens() {
		return creditTokens;
	}

	public void setCreditTokens(long creditTokens) {
		this.creditTokens = creditTokens;
	}
	
	
	  public List<Article> getArticles (){ return articles;}
	 
	
	  public List<Booster> getBoosters (){ return boosters;}
	
	public List<Defi> getDefis() {
		return defis;
	}

	public void setDefis(List<Defi> defis) {
		this.defis = defis;
	}

	public long getNbrParties() {
		return nbrParties;
	}

	public void setNbrParties(long nbrParties) {
		this.nbrParties = nbrParties;
	}

	public long getJoueurId() {
		return joueurId;
	}

	public void setBoosters(List<Booster> boosters) {
		this.boosters = boosters;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
	public long getMeilleurScore() {
		return meilleurScore;
	}
	public void setMeilleurScore(long meilleurScore) {
		this.meilleurScore = meilleurScore;
	}
	public Date getDerniereConnexion() {
		return derniereConnexion;
	}
	public void setDerniereConnexion(Date derniereConnexion) {
		this.derniereConnexion = derniereConnexion;
	}
	@Override
	public String toString(){
		return "Joueur avec une ID : " + this.joueurId+" de nom : "+this.nom;
	}
	
	
}
