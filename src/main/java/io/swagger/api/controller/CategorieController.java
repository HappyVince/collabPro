package io.swagger.api.controller;

import java.util.ArrayList;
import java.util.HashSet;
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
import io.swagger.api.repository.CollaborateurRepository;
import io.swagger.api.repository.CompetenceRepository;
import io.swagger.api.repository.NiveauRepository;
import io.swagger.model.Categorie;
import io.swagger.model.Collaborateur;
import io.swagger.model.Competence;
import io.swagger.model.Niveau;
import io.swagger.modelDTO.CategorieDTO;
import io.swagger.modelDTO.CompetenceDTO;

@RestController
public class CategorieController {

//	CompetenceMapper competenceMapper = Selma.builder(CompetenceMapper.class).build();

	CategorieMapper categorieMapper = Selma.builder(CategorieMapper.class).build();

	@Autowired
	CategorieRepository categorieRepository;
	@Autowired
	NiveauRepository niveauRepository;
	@Autowired
	CompetenceRepository competenceRepository;
	@Autowired
	CollaborateurRepository collaborateurRepository;

//	@Autowired
//	CompetenceRepository competenceRepository;

	@PostMapping("/categorie")
	Categorie create(@RequestBody CategorieDTO categorieDTO) {
		Categorie categorie = categorieMapper.asCategorie(categorieDTO);
		Iterable<Categorie> catext=categorieRepository.findByNomCategorie(categorie.getNomCategorie());
		String aa=catext.toString();

		if (aa=="[]" ) {

			return categorieRepository.save(categorie);

		} else {
			return null;
		}

	}

	@GetMapping("/categorie")
	Iterable<Categorie> read(@RequestBody CategorieDTO categorieDTO){
		return categorieRepository.findAll();
	}

	@GetMapping("/categorie/listnote/{idcoll}")
	Iterable<Categorie> read(@PathVariable Integer idcoll){
		Competence competence;
		Integer note;
		Collaborateur collaborateur=collaborateurRepository.findOne(idcoll);
		Iterable<Niveau> niveaux= niveauRepository.findByCollaborateur(collaborateur);
		for (Niveau niveau : niveaux) {
			competence=niveau.getCompetence();
			note=niveau.getNiveau();
			competence.setNote(note);
			niveau.setCompetence(competence);
		}

		return categorieRepository.findAll();
	}

	@GetMapping("/categoriesansparent/{idcoll}")
	Iterable<Categorie> readsansparent(@PathVariable Integer idcoll){

		Competence competence;
		Integer note;
		Collaborateur collaborateur=collaborateurRepository.findOne(idcoll);
		Iterable<Niveau> niveaux= niveauRepository.findByCollaborateur(collaborateur);
		for (Niveau niveau : niveaux) {
			competence=niveau.getCompetence();
			note=niveau.getNiveau();
			competence.setNote(note);
			niveau.setCompetence(competence);
		}

		Iterable<Categorie> categories=categorieRepository.findAll();

		for (Categorie categorie : categories) {

			categorie.setCategoriefils(categorieRepository.findByIdCategorieParent(categorie.getId()));
		}
		Iterable<Categorie> categoriesSansParent= categorieRepository.findByIdCategorieParent(null);


		return categoriesSansParent;
	}


	@GetMapping("/categoriesansparentnew/{idcoll}")
	List<Categorie> readsansparentnew(@PathVariable Integer idcoll){

		Competence competence;
		Integer note;
		Collaborateur collaborateur=collaborateurRepository.findOne(idcoll);
		Iterable<Niveau> niveaux= niveauRepository.findByCollaborateur(collaborateur);
		Iterable<Competence> competences;
		List<Competence> competencesnotees= new ArrayList<>();
		Iterable<Competence> competencesNote;
		for (Niveau niveau : niveaux) {
			competence=niveau.getCompetence();
			note=niveau.getNiveau();
			competence.setNote(note);
//			competence.setNoted(true);
			niveau.setCompetence(competence);
		}

		Iterable<Categorie> categories=categorieRepository.findAll();
//		Iterable<Categorie> categories=categorieRepository.findAll();
		List<Categorie> categorieARetourner=new ArrayList<>();
		List<Categorie> categoriesIntermediaire=new ArrayList<>();

		for (Categorie categorie : categories) {
			competences=competenceRepository.findByCategorieParent(categorie);
			competencesnotees.clear();
			for (Competence competencecurr: competences) {
				competencesnotees.add(competencecurr);
				if (competencecurr.getNote()!=null) {
//					competencecurr.setCategorieParent(null);
				}
			}

			categorie.setCompetences(competencesnotees);

			categoriesIntermediaire.add(categorie);
		}




		return categoriesIntermediaire;
	}


	@GetMapping("/categoriesansparentbis/{idcoll}")
	List<Categorie> readsansparentbis(@PathVariable Integer idcoll){

		Competence competence;
		Integer note;
		Collaborateur collaborateur=collaborateurRepository.findOne(idcoll);
		Iterable<Niveau> niveaux= niveauRepository.findByCollaborateur(collaborateur);
		Iterable<Competence> competences;
		List<Competence> competencesnotees= new ArrayList<>();
		Iterable<Competence> competencesNote;
		for (Niveau niveau : niveaux) {
			competence=niveau.getCompetence();
			note=niveau.getNiveau();
			competence.setNote(note);
//			competence.setNoted(true);
			niveau.setCompetence(competence);
		}

		Iterable<Categorie> categories=categorieRepository.findAll();
//		Iterable<Categorie> categories=categorieRepository.findAll();
		List<Categorie> categorieARetourner=new ArrayList<>();
		List<Categorie> categoriesIntermediaire=new ArrayList<>();

		for (Categorie categorie : categories) {
			competences=competenceRepository.findByCategorieParent(categorie);
			competencesnotees=new ArrayList<>();
			for (Competence competencecurr: competences) {
				if (competencecurr.getNote()!=null) {
					competencesnotees.add(competencecurr);
//					competencecurr.setCategorieParent(null);
				}
			}

			//competencesnotees.add(competenceRepository.findOne(17));
			if (categorie.getCompetences().size()!=0) {
				categorie.setCompetences(competencesnotees);

			}
			categoriesIntermediaire.add(categorie);

		}


		for (Categorie categorie : categoriesIntermediaire) {

			categorie.setCategoriefils(categorieRepository.findByIdCategorieParent(categorie.getId()));
		}
		List<Categorie> categoriesSansParent= new ArrayList<>();
		for (Categorie categorie : categoriesIntermediaire) {
			if (categorie.getIdCategorieParent()==null) {
				categorieARetourner.add(categorie);
			}
		}

		return categorieARetourner;
	}

	@GetMapping("/categoriesansparentbisbis/{idcoll}")
	List<Categorie> readsansparentbisbis(@PathVariable Integer idcoll){

		Competence competence;
		Integer note;
		Collaborateur collaborateur=collaborateurRepository.findOne(idcoll);
		Iterable<Niveau> niveaux= niveauRepository.findByCollaborateur(collaborateur);
		Iterable<Competence> competences;
		List<Competence> competencesnotees= new ArrayList<>();
		Iterable<Competence> competencesNote;
		for (Niveau niveau : niveaux) {
			competence=niveau.getCompetence();
			note=niveau.getNiveau();
			competence.setNote(note);
//			competence.setNoted(true);
			niveau.setCompetence(competence);
		}

		Iterable<Categorie> categories=categorieRepository.findAll();
//		Iterable<Categorie> categories=categorieRepository.findAll();
		List<Categorie> categorieARetourner=new ArrayList<>();
		List<Categorie> categoriesIntermediaire=new ArrayList<>();

		for (Categorie categorie : categories) {
			competences=competenceRepository.findByCategorieParent(categorie);
			competencesnotees=new ArrayList<>();
			for (Competence competencecurr: competences) {
				if (competencecurr.getNote()!=null) {
					competencesnotees.add(competencecurr);
//					competencecurr.setCategorieParent(null);
				}
			}

			//competencesnotees.add(competenceRepository.findOne(17));
			if (categorie.getCompetences().size()!=0) {
				categorie.setCompetences(competencesnotees);

			}
			categoriesIntermediaire.add(categorie);

		}
		List<Categorie> categorieAGarder=new ArrayList<>();
		for (Categorie categorie : categoriesIntermediaire) {
			if (categorie.getCompetences().size()!=0 && !categorieAGarder.contains(categorie)) {
				categorieAGarder.add(categorie);
				while (categorie.getIdCategorieParent()!=null) {
					categorie=categorieRepository.findOne(categorie.getIdCategorieParent());
					if (!categorieAGarder.contains(categorie)) {

						categorieAGarder.add(categorie);
					}
				}
			}
		}
		List<Categorie> categoriesFils=new ArrayList<>();
		for (Categorie categorie : categorieAGarder) {
			categoriesFils=new ArrayList<>();
			for (Categorie categorieBis : categorieAGarder) {
				if (categorieBis.getIdCategorieParent()==categorie.getId()) {
					categoriesFils.add(categorieBis);
				}
			}

			categorie.setCategoriefils(categoriesFils);
			//categorie.setCategoriefils(categorieRepository.findByIdCategorieParent(categorie.getId()));
		}
		List<Categorie> categoriesSansParent= new ArrayList<>();
		for (Categorie categorie : categorieAGarder) {
			if (categorie.getIdCategorieParent()==null) {
				categorieARetourner.add(categorie);
			}
		}

		return categorieARetourner;
	}



	@GetMapping("/categorie/listnoterange/{idcoll}")
	Iterable<Categorie> readrange(@PathVariable Integer idcoll){
		Competence competence;
		Integer note;
		Collaborateur collaborateur=collaborateurRepository.findOne(idcoll);
		Iterable<Niveau> niveaux= niveauRepository.findByCollaborateur(collaborateur);
		for (Niveau niveau : niveaux) {
			competence=niveau.getCompetence();
			note=niveau.getNiveau();
			competence.setNote(note);
			niveau.setCompetence(competence);
		}

		List<Categorie> categories=new ArrayList<>();
		List<Categorie> categoriesfilss=new ArrayList<>();
		Iterable<Categorie> categoriesSansParent= categorieRepository.findByIdCategorieParent(null);


//		for (Categorie categorie : categorieRepository.findAll()) {
//			categorie.get ( categorieRepository.findByIdCategorieParent(categorie.getIdCategorieParent()));
//
//		}


		return categoriesSansParent;
	}

	Iterable<Categorie> listFils(Categorie categorie){
		Iterable<Categorie> cats=categorieRepository.findByIdCategorieParent(categorie.getId());

		return cats;
	}

//	@GetMapping("/categorie/listnoteclasse/{idcoll}")
//	Iterable<Categorie> readlist(@PathVariable Integer idcoll){
//		Competence competence;
//		Integer note;
//		Collaborateur collaborateur=collaborateurRepository.findOne(idcoll);
//
//
//		Iterable<Niveau> niveaux= niveauRepository.findByCollaborateur(collaborateur);
//		for (Niveau niveau : niveaux) {
//			competence=niveau.getCompetence();
//			note=niveau.getNiveau();
//			competence.setNote(note);
//			niveau.setCompetence(competence);
//		}
//
//
//
//		Iterable<Categorie> categoriesSansParent= categorieRepository.findByIdCategorieParent(null);
//		List<Categorie> categories= new ArrayList<>();
//		for (Categorie categorie : categoriesSansParent) {
//			categories.add(categorie);
//			Iterable<Categorie> categoriesfilss= categorieRepository.findByIdCategorieParent(categorie.getId());
//			for (Categorie categoriefils : categoriesfilss) {
//				categoriefils.
//			}
//
//		}
//		return categorieRepository.findAll();
//	}

	@GetMapping("/categorie/{id}")
	Categorie findById(@PathVariable Integer id) {
		return categorieRepository.findOne(id);
	}

//	@GetMapping("/categoriebis/{id}")
//	Categorie idbis(@PathVariable Integer id) {
//		Categorie categorie=categorieRepository.findOne(id);
////		Competence competence=competenceRepository.findOne(17);
//		List<Competence> competences=new ArrayList<>();
//		competences.add(competence);
//		categorie.setCompetences(competences);
//		return categorie;
//	}

	@GetMapping("/categorie/categorieancetre/{id}")
	public ArrayList<Categorie> categorieAncetere(@PathVariable Integer id) {
		//Recup categorie

		ArrayList<Categorie> categoriesAncetre = findAncestor(id);

		return categoriesAncetre;
	}

	public ArrayList<Categorie> findAncestor(Integer id) {
		ArrayList<Categorie> categoriesAncetre=new ArrayList<Categorie>();
		Categorie categorie= categorieRepository.findOne(id);
		categoriesAncetre.add(categorie);
		Integer idParent = categorie.getIdCategorieParent();


		while (categorie.getIdCategorieParent()!=null) {
			categorie= categorieRepository.findOne(idParent);
			categoriesAncetre.add(categorie);
			idParent= categorie.getIdCategorieParent();

		}
		return categoriesAncetre;
	}


//	@GetMapping("/categorie/withnotecoll/{idcollab}")
//	public ArrayList<Categorie> categorieNote(@PathVariable Integer idcollab) {
//		//Recup categorie
//		Competence competence;
//		Niveau niveaub;
//		Collaborateur collaborateur=collaborateurRepository.findOne(idcollab);
//		Iterable<Niveau> niveaux= niveauRepository.findByCollaborateur(collaborateur);
//		List<Competence> competences= new ArrayList<>();
//		List<Integer> ids= new ArrayList<>();
//		for (Niveau niveau : niveaux) {
//			if (!ids.contains(niveau.getCompetence().getId())) {
//				ids.add(niveau.getCompetence().getId());
//				competence=niveau.getCompetence();
////				niveaub=niveau.getNiveau()
//				//competence.setNiveaux();
//				competences.add(niveau.getCompetence());
//			}
//		}
//
//
//
//		return null;
//	}

	@PutMapping("/categorie")
	Categorie update(@RequestBody CategorieDTO categorieDTO){
		Categorie categorie = categorieMapper.asCategorie(categorieDTO);
		Iterable<Categorie> catext=categorieRepository.findByNomCategorie(categorie.getNomCategorie());
		String aa=catext.toString();

		if (aa=="[]" ) {

			return categorieRepository.save(categorie);

		} else {
			return null;
		}
		//return categorieRepository.save(categorie);
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
