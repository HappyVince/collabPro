package io.swagger.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String idCategorieParent;
	private String nomCategorie;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="CATEGORIE_ID")
	private List<Competence> competences = new ArrayList<Competence>();


	public String getIdCategorieParent() {
		return idCategorieParent;
	}


	public void setIdCategorieParent(String idCategorieParent) {
		this.idCategorieParent = idCategorieParent;
	}


	public String getIdCategorie() {
		return idCategorieParent;
	}


	public void setIdCategorie(String idCategorie) {
		this.idCategorieParent = idCategorie;
	}


	public String getNomCategorie() {
		return nomCategorie;
	}


	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}


	public List<Competence> getCompetences() {
		return competences;
	}


	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getId() {
		return id;
	}

}
