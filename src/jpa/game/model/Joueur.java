package jpa.game.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "joueur")

public class Joueur {

	@Id
	@Column(name = "id_joueur")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToMany
	@JoinTable(name = "joueur_partie", joinColumns = @JoinColumn(name = "id_joueur", referencedColumnName = "id_joueur"), inverseJoinColumns = @JoinColumn(name = "id_partie", referencedColumnName = "id_partie"))
	private Set<Partie> parties;

	@OneToOne
	@JoinColumn(name = "id_avatar")
	private Avatar avatar;

	@Column(name = "nom", length = 30, nullable = false)
	private String nom;

	@Column(name = "prenom", length = 30, nullable = false)
	private String prenom;

	@Column(name = "date_naissance", nullable=true)
	private LocalDate dateNaissance;

	public Joueur() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Partie> getParties() {
		return parties;
	}

	public void setParties(Set<Partie> parties) {
		this.parties = parties;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return "Joueur [id=" + id + ", parties=" + parties + ", avatar=" + avatar + ", nom=" + nom + ", prenom="
				+ prenom + ", dateNaissance=" + dateNaissance + "]";
	}

}
