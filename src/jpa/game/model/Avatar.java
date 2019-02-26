package jpa.game.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "avatar")

public class Avatar {

	@Id
	@Column(name = "id_personnage")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(mappedBy="avatar")
	private Set<Joueur> joueurs;

	@OneToMany(mappedBy="avatar")
	private Set<Engin> engins;

	@Column(name = "nom", length = 50, nullable = false)
	private String nom;

	@Column(name = "puissance", length = 11, nullable = false)
	private Integer puissance;

	public Avatar() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Set<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(Set<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public Set<Engin> getEngins() {
		return engins;
	}

	public void setEngins(Set<Engin> engins) {
		this.engins = engins;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getPuissance() {
		return puissance;
	}

	public void setPuissance(Integer puissance) {
		this.puissance = puissance;
	}

	@Override
	public String toString() {
		return "Avatar [id=" + id + ", joueurs=" + joueurs + ", engins=" + engins + ", nom=" + nom + ", puissance="
				+ puissance + "]";
	}

	

}