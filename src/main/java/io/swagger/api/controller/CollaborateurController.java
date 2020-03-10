package io.swagger.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.xebia.extras.selma.Selma;
import io.swagger.api.mapper.CategorieMapper;
import io.swagger.api.mapper.CollaborateurMapper;
import io.swagger.api.mapper.NiveauMapper;
import io.swagger.api.repository.CategorieRepository;
import io.swagger.api.repository.CollaborateurRepository;
import io.swagger.model.Categorie;
import io.swagger.model.Collaborateur;
import io.swagger.model.Niveau;
import io.swagger.modelDTO.CategorieDTO;
import io.swagger.modelDTO.CollaborateurDTO;
import io.swagger.modelDTO.NiveauDTO;

@RestController
public class CollaborateurController {

	CollaborateurMapper collaborateurMapper = Selma.builder(CollaborateurMapper.class).build();
	NiveauMapper niveauMapper = Selma.builder(NiveauMapper.class).build();

	// CategorieMapper categorieMapper =
	// Selma.builder(CategorieMapper.class).build();

	@Autowired
	CollaborateurRepository collaborateurRepository;

	// @Autowired
	// CategorieRepository categorieRepository;

	@PostMapping("/collaborateur")
	Collaborateur create(@RequestBody CollaborateurDTO collaborateurDTO) {
		Collaborateur collaborateur = collaborateurMapper.asCollaborateur(collaborateurDTO);
		return collaborateurRepository.save(collaborateur);
	}

	@GetMapping("/collaborateur")
	List<Collaborateur> read(@RequestBody CollaborateurDTO collaborateurDTO) {
		return collaborateurRepository.findAll();
	}

	@GetMapping("/collaborateur/{id}")
	Collaborateur findById(@PathVariable Integer id) {
		return collaborateurRepository.findOne(id);
	}

	// @PutMapping("/collaborateur/{id}")
	// Collaborateur addNiveauToCollaborateur(@PathVariable Integer id,@RequestBody
	// NiveauDTO niveauDTO) {
	//
	// //Find collaborateur to add Niveau to
	// Collaborateur collaborateur = collaborateurRepository.findOne(id);
	// //Retrieve Niveaux list
	// List<Niveau> collaborateurNiveaux = collaborateur.getNiveaux();
	//
	// Niveau niveau = niveauMapper.asNiveau(niveauDTO);
	//
	// //Add the niveau to niveaux tab
	// collaborateurNiveaux.add(niveau);
	// collaborateur.setNiveaux(collaborateurNiveaux);
	// return collaborateurRepository.save(collaborateur);
	// }
	//
	// @PutMapping("/collaborateur/{id}/categorie")
	// Collaborateur addNiveauToCollaborateurViaCategorie(@PathVariable Integer
	// id,@RequestBody CategorieDTO categorieDTO) {
	//
	// //Find collaborateur to add Niveau to
	// Collaborateur collaborateur = collaborateurRepository.findOne(id);
	// //Retrieve Niveaux list
	// List<Niveau> collaborateurNiveaux = collaborateur.getNiveaux();
	// Categorie categorie = categorieMapper.asCategorie(categorieDTO);
	// Niveau niveau = categorie.getCompetences().get(0).getNiveaux().get(0);
	//
	// categorieRepository.save(categorie);
	//
	// //Add the niveau to niveaux tab
	// collaborateurNiveaux.add(niveau);
	// collaborateur.setNiveaux(collaborateurNiveaux);
	// return collaborateurRepository.save(collaborateur);
	// }

	@PutMapping("/collaborateur")
	Collaborateur update(@RequestBody CollaborateurDTO collaborateurDTO) {
		Collaborateur collaborateur = collaborateurMapper.asCollaborateur(collaborateurDTO);
		return collaborateurRepository.save(collaborateur);
	}

	@DeleteMapping("/collaborateur/{id}")
	void delete(@PathVariable Integer id) {
		collaborateurRepository.delete(id);
	}

	@GetMapping("/collaborateur/search")
	Iterable<Collaborateur> findByQuery(@RequestParam(value = "prenom", required = false) String prenom,
			@RequestParam(value = "nom", required = false) String nom) {
		if (prenom != null && nom != null)
			return collaborateurRepository.findByPrenomAndNom(prenom, nom);
		else if (prenom != null)
			return collaborateurRepository.findByPrenom(prenom);
		else if (nom != null)
			return collaborateurRepository.findByNom(nom);
		else
			return collaborateurRepository.findAll();
	}
}
