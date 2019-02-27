package jpa.game.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "engin")

// Heritage de la classe Engin avec 1 Table/Classe
@Inheritance(strategy= InheritanceType.JOINED) 

public abstract class Engin {

	@Id
	@Column(name = "id_engin")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_avatar")
	private Avatar avatar;

	@Column(name = "couleur", length = 50, nullable = false)
	private String couleur;

	@Column(name = "vitesse_max")
	private Integer vitesseMax;

	public Engin() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Integer getVitesseMax() {
		return vitesseMax;
	}

	public void setVitesseMax(Integer vitesseMax) {
		this.vitesseMax = vitesseMax;
	}

	@Override
	public String toString() {
		return "Engin [id=" + id + ", couleur=" + couleur + ", vitesseMax=" + vitesseMax + "]";
	}

	

}
