package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Competence
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T13:33:09.875Z")

public class Competence   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("nomcompetence")
  private String nomcompetence = null;

  @JsonProperty("idcategorie")
  private Long idcategorie = null;

  public Competence id(Long id) {
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

  public Competence nomcompetence(String nomcompetence) {
    this.nomcompetence = nomcompetence;
    return this;
  }

  /**
   * Get nomcompetence
   * @return nomcompetence
  **/
  @ApiModelProperty(example = "Demarrer Eclipse", required = true, value = "")
  @NotNull


  public String getNomcompetence() {
    return nomcompetence;
  }

  public void setNomcompetence(String nomcompetence) {
    this.nomcompetence = nomcompetence;
  }

  public Competence idcategorie(Long idcategorie) {
    this.idcategorie = idcategorie;
    return this;
  }

  /**
   * Get idcategorie
   * @return idcategorie
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getIdcategorie() {
    return idcategorie;
  }

  public void setIdcategorie(Long idcategorie) {
    this.idcategorie = idcategorie;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Competence competence = (Competence) o;
    return Objects.equals(this.id, competence.id) &&
        Objects.equals(this.nomcompetence, competence.nomcompetence) &&
        Objects.equals(this.idcategorie, competence.idcategorie);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nomcompetence, idcategorie);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Competence {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nomcompetence: ").append(toIndentedString(nomcompetence)).append("\n");
    sb.append("    idcategorie: ").append(toIndentedString(idcategorie)).append("\n");
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

