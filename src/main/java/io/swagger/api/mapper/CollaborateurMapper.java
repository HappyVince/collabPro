package io.swagger.api.mapper;

import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;
import fr.xebia.extras.selma.Selma;
import io.swagger.model.Collaborateur;
import io.swagger.model.Niveau;
import io.swagger.modelDTO.CollaborateurDTO;
import io.swagger.modelDTO.NiveauDTO;

@Mapper
public interface CollaborateurMapper {

	CollaborateurMapper mapper = Selma.builder(CollaborateurMapper.class).build();

	// This will update the given order
	Collaborateur asCollaborateur(CollaborateurDTO in, Collaborateur out);

	// Returns a new instance of CollaborateurDTO mapped from Collaborateur source
	@Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
	CollaborateurDTO asCollaborateurDTO(Collaborateur source);

	// Returns a new instance of Collaborateur mapped from CollaborateurDTO source
	@Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
	Collaborateur asCollaborateur(CollaborateurDTO source);




	// This will update the given order
	Niveau asNiveau(NiveauDTO in, Niveau out);

	// Returns a new instance of CollaborateurDTO mapped from Collaborateur source
	@Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
	NiveauDTO asNiveauDTO(Niveau source);

	// Returns a new instance of Collaborateur mapped from CollaborateurDTO source
	@Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
	Niveau asNiveau(NiveauDTO source);
}