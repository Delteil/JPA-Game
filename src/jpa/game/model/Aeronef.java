package jpa.game.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aeronef")

public class Aeronef extends Engin{
	
	@Id
	@Column(name="id_aeronef")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="type", length= 50, nullable=false)
	private String type;
	
	@Column(name="autonomie_km", length= 10, nullable=false)
	private Integer autonomieKm;
	

}
