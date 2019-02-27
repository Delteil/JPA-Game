package jpa.game.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avatar")

public class Avatar {

	@Id
	@Column(name = "id_avatar")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(mappedBy = "avatar")
	private Joueur joueur;

	@OneToMany(mappedBy = "avatar")
	private Set<Engin> engins;

	@Column(name = "nom", length = 50, nullable = false)
	private String nom;

	@Column(name = "puissance", length = 11, nullable = false)
	private Integer puissance;

	public Avatar() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
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
		return "Avatar [id=" + id + ", engins=" + engins + ", nom=" + nom + ", puissance=" + puissance + "]";
	}

}