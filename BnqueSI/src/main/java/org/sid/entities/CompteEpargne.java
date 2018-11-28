package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("CE")
@XmlType(name="CE")
public class CompteEpargne extends Compte {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6355258766077417699L;
	
	private double taux;
	
	public CompteEpargne() {
		super();
	}
	
	public double getTaux() {
		return taux;
	}
	
	public void setTaux(double decouvert) {
		this.taux = decouvert;
	}

	public CompteEpargne(String code, double solde, Date dateCreation) {
		super(code, solde, dateCreation);
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(String code, double solde, Date dateCreation, double taux) {
		super(code, solde, dateCreation);
		this.taux = taux;
	}
	
}