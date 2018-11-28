package org.sid.dao;

import java.util.List;

import org.sid.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(/*excerptProjection=EtudiantProjection.class*/)
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{

	public List<Etudiant> findByNomContains(String nom);
}
