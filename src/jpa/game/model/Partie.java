package jpa.game.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "partie")

public class Partie {

	@Id
	@Column(name = "id_partie")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToMany(mappedBy = "parties")
	private List<Joueur> joueurs;

	@Column(name = "niveau", length = 30, nullable = false)
	private int niveau;

	@Column(name = "score", length = 30, nullable = false)
	private int score;

	@Column(name = "date", length = 30, nullable = false)
	private LocalDate date;
	

	public Partie() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Partie [id=" + id + ", joueurs=" + joueurs + ", niveau=" + niveau + ", score=" + score + ", date="
				+ date + "]";
	}

	
}
