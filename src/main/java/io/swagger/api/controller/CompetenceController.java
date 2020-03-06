package io.swagger.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.repository.CompetenceRepository;
import io.swagger.model.Competence;

@RestController
public class CompetenceController {

	@Autowired
	CompetenceRepository iCompetence;

	@PostMapping("/competence")
	Competence create(@RequestBody Competence competence) {
		return iCompetence.save(competence);
	}

	@GetMapping("/competence")
	Iterable<Competence> read(@RequestBody Competence competence){
		return iCompetence.findAll();
	}

	@GetMapping("/competence/{id}")
	Competence findById(@PathVariable Integer id) {
		return iCompetence.findOne(id);
	}

	@PutMapping("/competence")
	Competence update(@RequestBody Competence competence){
		return iCompetence.save(competence);
	}

	@DeleteMapping("/competence/{id}")
	void delete(@PathVariable Integer id) {
		iCompetence.delete(id);
	}

}
