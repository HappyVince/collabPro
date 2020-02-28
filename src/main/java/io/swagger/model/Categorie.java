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
 * Categorie
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T13:33:09.875Z")

public class Categorie   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("nomcategorie")
  private String nomcategorie = null;

  @JsonProperty("idcategorieparent")
  private Long idcategorieparent = null;

  public Categorie id(Long id) {
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

  public Categorie nomcategorie(String nomcategorie) {
    this.nomcategorie = nomcategorie;
    return this;
  }

  /**
   * Get nomcategorie
   * @return nomcategorie
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getNomcategorie() {
    return nomcategorie;
  }

  public void setNomcategorie(String nomcategorie) {
    this.nomcategorie = nomcategorie;
  }

  public Categorie idcategorieparent(Long idcategorieparent) {
    this.idcategorieparent = idcategorieparent;
    return this;
  }

  /**
   * Get idcategorieparent
   * @return idcategorieparent
  **/
  @ApiModelProperty(value = "")


  public Long getIdcategorieparent() {
    return idcategorieparent;
  }

  public void setIdcategorieparent(Long idcategorieparent) {
    this.idcategorieparent = idcategorieparent;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Categorie categorie = (Categorie) o;
    return Objects.equals(this.id, categorie.id) &&
        Objects.equals(this.nomcategorie, categorie.nomcategorie) &&
        Objects.equals(this.idcategorieparent, categorie.idcategorieparent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nomcategorie, idcategorieparent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Categorie {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nomcategorie: ").append(toIndentedString(nomcategorie)).append("\n");
    sb.append("    idcategorieparent: ").append(toIndentedString(idcategorieparent)).append("\n");
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

