package io.swagger.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.repository.CategorieRepository;
import io.swagger.model.Categorie;

@RestController
public class CategorieController {

	@Autowired
	CategorieRepository iCategorie;

	@PostMapping("/categorie")
	Categorie create(@RequestBody Categorie categorie) {
		return iCategorie.save(categorie);
	}

	@GetMapping("/categorie")
	Iterable<Categorie> read(@RequestBody Categorie categorie){
		return iCategorie.findAll();
	}

	@GetMapping("/categorie/{id}")
	Categorie findById(@PathVariable Integer id) {
		return iCategorie.findOne(id);
	}

	@PutMapping("/categorie")
	Categorie update(@RequestBody Categorie categorie){
		return iCategorie.save(categorie);
	}

	@DeleteMapping("/categorie/{id}")
	void delete(@PathVariable Integer id) {
		iCategorie.delete(id);
	}

}
