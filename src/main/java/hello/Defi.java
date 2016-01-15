package hello;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Defi {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long defiId;
	private String titre;
	private String description;
	@ManyToMany(mappedBy="defis")
	private List<Joueur> joueur;
	
	protected Defi(){}
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
	public List<Joueur> getJoueur() {
		return joueur;
	}
	public void setJoueur(List<Joueur> joueur) {
		this.joueur = joueur;
	}
	public long getDefiId() {
		return defiId;
	}
	@Override
	public String toString(){
		return "Defi avec une ID : " + this.defiId
				;
	}
	
}
