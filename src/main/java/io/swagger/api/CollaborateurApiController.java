package io.swagger.api;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Collaborateur;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T13:33:09.875Z")

@Controller
public class CollaborateurApiController implements CollaborateurApi {

    private static final Logger log = LoggerFactory.getLogger(CollaborateurApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CollaborateurApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addCollaborateur(@ApiParam(value = "Ajoute un collaborateur" ,required=true )  @Valid @RequestBody Collaborateur body) {
        String accept = request.getHeader("Accept");
        Connection c = null;
	      Statement stmt = null;
	      String nom = body.getNom();
	      String prenom = body.getPrenom();
	      Integer idCollab = Math.toIntExact(body.getId());
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/postgres",
	            "postgres", "Adrien11081994");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "INSERT INTO \"Collaborateur\" (\"idCollab\",\"nom\",\"prenom\") "
	            + "VALUES ('"+idCollab+"', '"+nom+"','"+prenom+"');";
	         stmt.executeUpdate(sql);
	         stmt.close();
	         c.commit();
	         c.close();
	      } catch (Exception e) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Records created successfully");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteCollaborateur(@ApiParam(value = "ID of collaborateur to return",required=true) @PathVariable("collaborateurId") Long collaborateurId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Collaborateur> getCollaborateurById(@ApiParam(value = "ID of collaborateur to return",required=true) @PathVariable("collaborateurId") Long collaborateurId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Collaborateur>(objectMapper.readValue("<Collaborateur>  <id>123456789</id>  <nom>dupond</nom>  <prenom>pierre</prenom>  <niveaux>  </niveaux></Collaborateur>", Collaborateur.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Collaborateur>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Collaborateur>(objectMapper.readValue("{  \"niveaux\" : [ {    \"collaborateurid\" : 5,    \"competenceid\" : 1,    \"id\" : 6,    \"niveau\" : 5  }, {    \"collaborateurid\" : 5,    \"competenceid\" : 1,    \"id\" : 6,    \"niveau\" : 5  } ],  \"id\" : 0,  \"nom\" : \"dupond\",  \"prenom\" : \"pierre\"}", Collaborateur.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Collaborateur>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Collaborateur>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> selectCollaborateur() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateCollaborateur(@ApiParam(value = "ID of collaborateur to update",required=true) @PathVariable("collaborateurId") Long collaborateurId,@ApiParam(value = "Update un collaborateur" ,required=true )  @Valid @RequestBody Collaborateur body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
