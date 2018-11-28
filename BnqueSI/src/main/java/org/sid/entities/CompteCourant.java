package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("CC")
@XmlType(name="CC")
public class CompteCourant extends Compte {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8172027034834281715L;
	
	private double decouvert;
	
	public CompteCourant() {
		super();
	}
	
	public double getDecouvert() {
		return decouvert;
	}
	
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public CompteCourant(String code, double solde, Date dateCreation) {
		super(code, solde, dateCreation);
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(String code, double solde, Date dateCreation, double decouvert) {
		super(code, solde, dateCreation);
		this.decouvert = decouvert;
	}
	
}