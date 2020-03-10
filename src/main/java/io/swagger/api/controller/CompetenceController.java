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
import io.swagger.api.mapper.CompetenceMapper;
import io.swagger.api.repository.CompetenceRepository;
import io.swagger.model.Competence;
import io.swagger.modelDTO.CompetenceDTO;

@RestController
public class CompetenceController {

	CompetenceMapper mapper = Selma.builder(CompetenceMapper.class).build();

	@Autowired
	CompetenceRepository competenceRepository;

	@PostMapping("/competence")
	Competence create(@RequestBody CompetenceDTO competenceDTO) {
		Competence competence = mapper.asCompetence(competenceDTO);
		return competenceRepository.save(competence);
	}

	@GetMapping("/competence")
	Iterable<Competence> read(@RequestBody CompetenceDTO competenceDTO){
		return competenceRepository.findAll();
	}

	@GetMapping("/competence/{id}")
	Competence findById(@PathVariable Integer id) {
		return competenceRepository.findOne(id);
	}

	@PutMapping("/competence")
	Competence update(@RequestBody CompetenceDTO competenceDTO){
		Competence competence = mapper.asCompetence(competenceDTO);
		return competenceRepository.save(competence);
	}

	@DeleteMapping("/competence/{id}")
	void delete(@PathVariable Integer id) {
		competenceRepository.delete(id);
	}

}
