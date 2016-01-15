package hello;

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
	
	@ManyToMany(mappedBy="boosters")
	private List<Joueur> joueurs;

	protected Booster(){}
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
	@Override
	public String toString(){
		return "Booster avec une ID : " + this.boosterId+" de nom : "+this.nom;
	}
}
