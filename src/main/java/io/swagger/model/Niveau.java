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
 * Niveau
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T13:33:09.875Z")

public class Niveau   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("competenceid")
  private Long competenceid = null;

  @JsonProperty("collaborateurid")
  private Long collaborateurid = null;

  @JsonProperty("niveau")
  private Long niveau = null;

  public Niveau id(Long id) {
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

  public Niveau competenceid(Long competenceid) {
    this.competenceid = competenceid;
    return this;
  }

  /**
   * Get competenceid
   * @return competenceid
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getCompetenceid() {
    return competenceid;
  }

  public void setCompetenceid(Long competenceid) {
    this.competenceid = competenceid;
  }

  public Niveau collaborateurid(Long collaborateurid) {
    this.collaborateurid = collaborateurid;
    return this;
  }

  /**
   * Get collaborateurid
   * @return collaborateurid
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getCollaborateurid() {
    return collaborateurid;
  }

  public void setCollaborateurid(Long collaborateurid) {
    this.collaborateurid = collaborateurid;
  }

  public Niveau niveau(Long niveau) {
    this.niveau = niveau;
    return this;
  }

  /**
   * Get niveau
   * @return niveau
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getNiveau() {
    return niveau;
  }

  public void setNiveau(Long niveau) {
    this.niveau = niveau;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Niveau niveau = (Niveau) o;
    return Objects.equals(this.id, niveau.id) &&
        Objects.equals(this.competenceid, niveau.competenceid) &&
        Objects.equals(this.collaborateurid, niveau.collaborateurid) &&
        Objects.equals(this.niveau, niveau.niveau);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, competenceid, collaborateurid, niveau);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Niveau {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    competenceid: ").append(toIndentedString(competenceid)).append("\n");
    sb.append("    collaborateurid: ").append(toIndentedString(collaborateurid)).append("\n");
    sb.append("    niveau: ").append(toIndentedString(niveau)).append("\n");
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

