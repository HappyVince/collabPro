package io.swagger.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.Categorie;
import io.swagger.model.Competence;

public interface CompetenceRepository extends JpaRepository<Competence, Integer> {

	Iterable<Competence> findByNomCompetence(String nomCompetence);
	Iterable<Competence> findByCategorieParent(Categorie categorie);
//	Iterable<Competence> findByNote(Integer note);

}
