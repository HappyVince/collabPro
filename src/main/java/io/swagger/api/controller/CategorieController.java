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
import io.swagger.api.mapper.CategorieMapper;
import io.swagger.api.mapper.CompetenceMapper;
import io.swagger.api.repository.CategorieRepository;
import io.swagger.api.repository.CompetenceRepository;
import io.swagger.model.Categorie;
import io.swagger.model.Competence;
import io.swagger.modelDTO.CategorieDTO;
import io.swagger.modelDTO.CompetenceDTO;

@RestController
public class CategorieController {

//	CompetenceMapper competenceMapper = Selma.builder(CompetenceMapper.class).build();

	CategorieMapper categorieMapper = Selma.builder(CategorieMapper.class).build();

	@Autowired
	CategorieRepository categorieRepository;

//	@Autowired
//	CompetenceRepository competenceRepository;

	@PostMapping("/categorie")
	Categorie create(@RequestBody CategorieDTO categorieDTO) {
		Categorie categorie = categorieMapper.asCategorie(categorieDTO);
		return categorieRepository.save(categorie);
	}

	@GetMapping("/categorie")
	Iterable<Categorie> read(@RequestBody CategorieDTO categorieDTO){
		return categorieRepository.findAll();
	}

	@GetMapping("/categorie/{id}")
	Categorie findById(@PathVariable Integer id) {
		return categorieRepository.findOne(id);
	}

	@PutMapping("/categorie")
	Categorie update(@RequestBody CategorieDTO categorieDTO){
		Categorie categorie = categorieMapper.asCategorie(categorieDTO);
		return categorieRepository.save(categorie);
	}

//	@PutMapping("/categorie/{id}")
//	Categorie addCompetenceToCategorie(@PathVariable Integer id,@RequestBody CompetenceDTO competenceDTO) {
//
//		//Find categorie to add Competence to
//		Categorie categorie = categorieRepository.findOne(id);
//		//Retrieve Competences list
//		List<Competence> categorieCompetences = categorie.getCompetences();
//
//		Competence competence = competenceMapper.asCompetence(competenceDTO);
//
//		//Add the competence to competences tab
//		categorieCompetences.add(competence);
//		categorie.setCompetences(categorieCompetences);
//		return categorieRepository.save(categorie);
//	}

	@DeleteMapping("/categorie/{id}")
	void delete(@PathVariable Integer id) {
		categorieRepository.delete(id);
	}

}
