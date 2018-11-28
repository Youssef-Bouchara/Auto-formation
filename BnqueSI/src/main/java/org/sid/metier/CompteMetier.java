package org.sid.metier;

import org.sid.entities.Compte;

public interface CompteMetier {
	
	public Compte saveCompte(Compte c);
	public Compte getCompte(String code);

}
