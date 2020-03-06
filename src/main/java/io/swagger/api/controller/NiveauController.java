package io.swagger.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.repository.NiveauRepository;
import io.swagger.model.Niveau;

@RestController
public class NiveauController {

	@Autowired
	NiveauRepository iNiveau;

	@PostMapping("/niveau")
	Niveau create(@RequestBody Niveau niveau) {
		return iNiveau.save(niveau);
	}

	@GetMapping("/niveau")
	Iterable<Niveau> read(@RequestBody Niveau niveau){
		return iNiveau.findAll();
	}

	@GetMapping("/niveau/{id}")
	Niveau findById(@PathVariable Integer id) {
		return iNiveau.findOne(id);
	}

	@PutMapping("/niveau")
	Niveau update(@RequestBody Niveau niveau){
		return iNiveau.save(niveau);
	}

	@DeleteMapping("/niveau/{id}")
	void delete(@PathVariable Integer id) {
		iNiveau.delete(id);
	}

}
