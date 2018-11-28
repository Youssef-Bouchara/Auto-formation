package metier;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement(name="compte")
@XmlAccessorType(XmlAccessType.FIELD)
public class Compte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long code;
	private Double solde;
	@XmlTransient
	private Date datecreations;
	
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	public Date getDatecreations() {
		return datecreations;
	}
	public void setDatecreations(Date datecreations) {
		this.datecreations = datecreations;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(Long code, Double solde, Date datecreations) {
		super();
		this.code = code;
		this.solde = solde;
		this.datecreations = datecreations;
	}
	
	
	
}
