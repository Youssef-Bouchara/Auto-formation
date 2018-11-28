package org.sid.metier;

import java.util.Date;

import org.sid.dao.CompteRepository;
import org.sid.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteMetierImpl implements CompteMetier {

	@Autowired
	private CompteRepository compteRepository;
	
	@Override
	public Compte saveCompte(Compte c) {
		c.setDateCreation(new Date());
		return this.compteRepository.save(c);
	}

	@Override
	public Compte getCompte(String code) {
		return this.compteRepository.findById(code).orElse(null);
	}
	

}
