package io.swagger.modelDTO;

import com.fasterxml.jackson.annotation.JsonProperty;


public class NiveauDTO {

	@JsonProperty
	private Long id;

	@JsonProperty
	private int niveau;


	private CompetenceDTO competence;


	private CollaborateurDTO collaborateur;



	public CompetenceDTO getCompetence() {
		return competence;
	}

	public void setCompetence(CompetenceDTO competence) {
		this.competence = competence;
	}

	public CollaborateurDTO getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(CollaborateurDTO collaborateur) {
		this.collaborateur = collaborateur;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CompetenceDTO getManufacturer() {
		return competence;
	}

	public void setManufacturer(CompetenceDTO manufacturer) {
		this.competence = manufacturer;
	}

	public CollaborateurDTO getModelType() {
		return collaborateur;
	}

	public void setModelType(CollaborateurDTO modelType) {
		this.collaborateur = modelType;
	}

	public Long getId() {
		return id;
	}
}
