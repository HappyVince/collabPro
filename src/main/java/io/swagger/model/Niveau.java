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
	private Competence competence;

	@ManyToOne
	private Collaborateur collaborateur;



	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	public Long getId() {
		return id;
	}
}
