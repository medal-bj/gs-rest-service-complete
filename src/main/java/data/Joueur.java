package data;

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
	private long JoueurId;
	private long meilleurScore;
	private Date derniereConnexion;
	private long classement;
	List<Article>articles;
	@ManyToMany
	  @JoinTable(name="Achat")
	  public List<Article> getArticles (){ return articles;}
	
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
