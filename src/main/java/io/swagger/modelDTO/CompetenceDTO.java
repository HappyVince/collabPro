package io.swagger.modelDTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CompetenceDTO {

	@JsonProperty
	private Long id;

	@JsonProperty
	private String nomCompetence;


	private List<NiveauDTO> niveaux = new ArrayList<NiveauDTO>();


	private CategorieDTO categorieParent;



	public String getNomCompetence() {
		return nomCompetence;
	}



	public void setNomCompetence(String nomCompetence) {
		this.nomCompetence = nomCompetence;
	}



	public List<NiveauDTO> getNiveaux() {
		return niveaux;
	}



	public void setNiveaux(List<NiveauDTO> niveaux) {
		this.niveaux = niveaux;
	}



	public CategorieDTO getCategorieParent() {
		return categorieParent;
	}



	public void setCategorieParent(CategorieDTO categorieParent) {
		this.categorieParent = categorieParent;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getId() {
		return id;
	}
}
