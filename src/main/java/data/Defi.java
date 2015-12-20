package data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Defi {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long defiId;
	private String titre;
	private String description;
	@ManyToOne(fetch=FetchType.LAZY)
	private Joueur joueur;
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	public long getDefiId() {
		return defiId;
	}
	
}
