package org.sid.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = -604368469406192388L;
	
}