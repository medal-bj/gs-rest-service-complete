package data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Booster {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long boosterId;
	private String nom;
	private String description;
	private String icone;
	private List<Joueur> joueurs;
	@ManyToMany(mappedBy="boosters")
    public List<Joueur> getJoueurs(){return joueurs;}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcone() {
		return icone;
	}
	public void setIcone(String icone) {
		this.icone = icone;
	}
	public long getBoosterId() {
		return boosterId;
	}
	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
}
