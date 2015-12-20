package data;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity

public class Joueur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long joueurId;
	private long meilleurScore;
	private Date derniereConnexion;
	private long classement;
	private long creditGemmes;
	private long creditTokens;
	@OneToMany(mappedBy="joueur")
	private List<Defi> defis;
	
	private long nbrParties;


	
	
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

	private List<Article>articles;
	@ManyToMany
	  @JoinTable(name="Achat")
	  public List<Article> getArticles (){ return articles;}
	
	private List<Booster> boosters;
	@ManyToMany
	  @JoinTable(name="Boosters")
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
	public long getClassement() {
		return classement;
	}
	public void setClassement(long classement) {
		this.classement = classement;
	}
}
