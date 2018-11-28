package org.sid.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Formation {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private int duree;
	@OneToMany(mappedBy="formation")
	private Collection<Etudiant> etudiants;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Formation(Long id, String nom, int duree, Collection<Etudiant> etudiants) {
		super();
		this.id = id;
		this.nom = nom;
		this.duree = duree;
		this.etudiants = etudiants;
	}

}
