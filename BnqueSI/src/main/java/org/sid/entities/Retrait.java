package org.sid.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9038715578896622877L;

}
