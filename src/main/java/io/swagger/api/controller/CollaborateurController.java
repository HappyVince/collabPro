package io.swagger.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.xebia.extras.selma.Selma;
import io.swagger.api.mapper.CollaborateurMapper;
import io.swagger.api.repository.CollaborateurRepository;
import io.swagger.model.Collaborateur;
import io.swagger.modelDTO.CollaborateurDTO;

@RestController
public class CollaborateurController {

//	CollaborateurMapper mapper;

	@Autowired
	CollaborateurRepository iCollaborateur;

	@PostMapping("/collaborateur")
	Collaborateur create(@RequestBody CollaborateurDTO collaborateurDTO) {
		Collaborateur collaborateur = CollaborateurMapper.mapper.asCollaborateur(collaborateurDTO);
		return iCollaborateur.save(collaborateur);
	}

	@GetMapping("/collaborateur")
	List<Collaborateur> read(@RequestBody Collaborateur collaborateur) {
		return iCollaborateur.findAll();
	}

	@GetMapping("/collaborateur/{id}")
	Collaborateur findById(@PathVariable Integer id) {
		return iCollaborateur.findOne(id);
	}

	@PutMapping("/collaborateur")
	Collaborateur update(@RequestBody Collaborateur collaborateur) {
		return iCollaborateur.save(collaborateur);
	}

	@DeleteMapping("/collaborateur/{id}")
	void delete(@PathVariable Integer id) {
		iCollaborateur.delete(id);
	}

}
