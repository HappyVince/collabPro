/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Collaborateur;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T13:33:09.875Z")

@Api(value = "collaborateur", description = "the collaborateur API")
public interface CollaborateurApi {

    @ApiOperation(value = "Ajoute  un collaborateur", nickname = "addCollaborateur", notes = "", tags={ "collaborateur", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/collaborateur",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addCollaborateur(@ApiParam(value = "Ajoute un collaborateur" ,required=true )  @Valid @RequestBody Collaborateur body);


    @ApiOperation(value = "supprime  un collaborateur", nickname = "deleteCollaborateur", notes = "", tags={ "collaborateur", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/collaborateur/{collaborateurId}",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteCollaborateur(@ApiParam(value = "ID of collaborateur to return",required=true) @PathVariable("collaborateurId") Long collaborateurId);


    @ApiOperation(value = "Find collaborateur by ID", nickname = "getCollaborateurById", notes = "Display a single collaborateur", response = Collaborateur.class, tags={ "collaborateur", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Collaborateur.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "collaborateur not found") })
    @RequestMapping(value = "/collaborateur/{collaborateurId}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Collaborateur> getCollaborateurById(@ApiParam(value = "ID of collaborateur to return",required=true) @PathVariable("collaborateurId") Long collaborateurId);


    @ApiOperation(value = "Selectionne tous les collaborateur", nickname = "selectCollaborateur", notes = "", tags={ "collaborateur", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/collaborateur",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.GET)
    ResponseEntity<Void> selectCollaborateur();


    @ApiOperation(value = "Update  un collaborateur", nickname = "updateCollaborateur", notes = "", tags={ "collaborateur", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/collaborateur/{collaborateurId}",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateCollaborateur(@ApiParam(value = "ID of collaborateur to update",required=true) @PathVariable("collaborateurId") Long collaborateurId,@ApiParam(value = "Update un collaborateur" ,required=true )  @Valid @RequestBody Collaborateur body);

}