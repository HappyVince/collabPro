package io.swagger.modelDTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategorieDTO {

	@JsonProperty
	private Integer id;
	@JsonProperty
	private String idCategorieParent;
	@JsonProperty
	private String nomCategorie;


	private List<CompetenceDTO> competences = new ArrayList<CompetenceDTO>();


	public String getIdCategorieParent() {
		return idCategorieParent;
	}


	public void setIdCategorieParent(String idCategorieParent) {
		this.idCategorieParent = idCategorieParent;
	}




	public String getNomCategorie() {
		return nomCategorie;
	}


	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}


	public List<CompetenceDTO> getCompetences() {
		return competences;
	}


	public void setCompetences(List<CompetenceDTO> competences) {
		this.competences = competences;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getId() {
		return id;
	}

}
