package io.swagger.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Niveau {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private int niveau;

	@ManyToOne
	private Competence manufacturer;

	@ManyToOne
	private Collaborateur modelType;



	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Competence getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Competence manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Collaborateur getModelType() {
		return modelType;
	}

	public void setModelType(Collaborateur modelType) {
		this.modelType = modelType;
	}

	public Long getId() {
		return id;
	}
}
