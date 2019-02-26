package jpa.game.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bolide")

public class Bolide extends Engin {

	@Id
	@Column(name = "id_bolide")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nb_roues", length = 10, nullable = false)
	private Integer nbRoues;

	@Column(name = "autonomie_heure", length = 10, nullable = false)
	private Integer autonomieHeure;

	public Bolide() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNbRoues() {
		return nbRoues;
	}

	public void setNbRoues(Integer nbRoues) {
		this.nbRoues = nbRoues;
	}

	public Integer getAutonomieHeure() {
		return autonomieHeure;
	}

	public void setAutonomieHeure(Integer autonomieHeure) {
		this.autonomieHeure = autonomieHeure;
	}

	@Override
	public String toString() {
		return "Bolide [id=" + id + ", nbRoues=" + nbRoues + ", autonomieHeure=" + autonomieHeure + "]";
	}
	
	
	
	

}
