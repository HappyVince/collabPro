package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Niveau;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Collaborateur
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T13:33:09.875Z")

public class Collaborateur   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("nom")
  private String nom = null;

  @JsonProperty("prenom")
  private String prenom = null;

  @JsonProperty("niveaux")
  @Valid
  private List<Niveau> niveaux = null;

  public Collaborateur id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Collaborateur nom(String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Get nom
   * @return nom
  **/
  @ApiModelProperty(example = "dupond", required = true, value = "")
  @NotNull


  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Collaborateur prenom(String prenom) {
    this.prenom = prenom;
    return this;
  }

  /**
   * Get prenom
   * @return prenom
  **/
  @ApiModelProperty(example = "pierre", required = true, value = "")
  @NotNull


  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public Collaborateur niveaux(List<Niveau> niveaux) {
    this.niveaux = niveaux;
    return this;
  }

  public Collaborateur addNiveauxItem(Niveau niveauxItem) {
    if (this.niveaux == null) {
      this.niveaux = new ArrayList<Niveau>();
    }
    this.niveaux.add(niveauxItem);
    return this;
  }

  /**
   * Get niveaux
   * @return niveaux
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Niveau> getNiveaux() {
    return niveaux;
  }

  public void setNiveaux(List<Niveau> niveaux) {
    this.niveaux = niveaux;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Collaborateur collaborateur = (Collaborateur) o;
    return Objects.equals(this.id, collaborateur.id) &&
        Objects.equals(this.nom, collaborateur.nom) &&
        Objects.equals(this.prenom, collaborateur.prenom) &&
        Objects.equals(this.niveaux, collaborateur.niveaux);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nom, prenom, niveaux);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Collaborateur {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    prenom: ").append(toIndentedString(prenom)).append("\n");
    sb.append("    niveaux: ").append(toIndentedString(niveaux)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

