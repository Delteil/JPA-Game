package jpa.game.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aeronef")

public class Aeronef extends Engin {

	@Id
	@Column(name = "id_aeronef")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "type", length = 50, nullable = false)
	private String type;

	@Column(name = "autonomie_km", length = 10, nullable = false)
	private Integer autonomieKm;

	public Aeronef() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getAutonomieKm() {
		return autonomieKm;
	}

	public void setAutonomieKm(Integer autonomieKm) {
		this.autonomieKm = autonomieKm;
	}

	@Override
	public String toString() {
		return "Aeronef [id=" + id + ", type=" + type + ", autonomieKm=" + autonomieKm + "]";
	}

}
