package io.swagger.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.xebia.extras.selma.Selma;
import io.swagger.api.mapper.NiveauMapper;
import io.swagger.api.repository.CompetenceRepository;
import io.swagger.api.repository.NiveauRepository;
import io.swagger.model.Competence;
import io.swagger.model.Niveau;
import io.swagger.modelDTO.NiveauDTO;

@RestController
public class NiveauController {

	NiveauMapper mapper = Selma.builder(NiveauMapper.class).build();

	@Autowired
	NiveauRepository niveauRepository;

	@Autowired
	CompetenceRepository competenceRepository;

	@PostMapping("/niveau")
	Niveau create(@RequestBody NiveauDTO niveauDTO) {
		Niveau niveau = mapper.asNiveau(niveauDTO);
		Competence competence = competenceRepository.findOne(niveauDTO.getCompetence().getId());
		if ( competence != null) {

		}
		return niveauRepository.save(niveau);
	}

	@GetMapping("/niveau")
	Iterable<Niveau> read(@RequestBody NiveauDTO niveauDTO){
		return niveauRepository.findAll();
	}

	@GetMapping("/niveau/{id}")
	Niveau findById(@PathVariable Integer id) {
		return niveauRepository.findOne(id);
	}

	@PutMapping("/niveau")
	Niveau update(@RequestBody NiveauDTO niveauDTO){
		Niveau niveau = mapper.asNiveau(niveauDTO);
		return niveauRepository.save(niveau);
	}

	@DeleteMapping("/niveau/{id}")
	void delete(@PathVariable Integer id) {
		niveauRepository.delete(id);
	}

}
