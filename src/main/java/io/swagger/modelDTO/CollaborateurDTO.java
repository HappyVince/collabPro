package io.swagger.modelDTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CollaborateurDTO {

	@JsonProperty
	private Long id;
	@JsonProperty
	private String prenom;
	@JsonProperty
	private String nom;

	private List<NiveauDTO> niveaux = new ArrayList<NiveauDTO>();


	public List<NiveauDTO> getNiveaux() {
		return niveaux;
	}

	public void setNiveaux(List<NiveauDTO> niveaux) {
		this.niveaux = niveaux;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
