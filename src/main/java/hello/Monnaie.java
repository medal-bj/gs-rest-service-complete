package hello;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Monnaie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long MonnaieId;
	private String nom;
	private String icone;
	private String description;
	private long credit;
	protected Monnaie(){}
	public long getCredit() {
		return credit;
	}
	public void setCredit(long credit) {
		this.credit = credit;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	private Joueur proprietaire;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getIcone() {
		return icone;
	}
	public void setIcone(String icone) {
		this.icone = icone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Joueur getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Joueur proprietaire) {
		this.proprietaire = proprietaire;
	}
	public long getMonnaieId() {
		return MonnaieId;
	}
}
