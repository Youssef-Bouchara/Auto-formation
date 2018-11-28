package org.sid.projections;

import org.sid.entities.Etudiant;
import org.sid.entities.Formation;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1", types= Etudiant.class )
public interface EtudiantProjection {
	
	String getNom();
	String getPrenom();
	String getDateNaissance();
	Formation getFormation();

}
