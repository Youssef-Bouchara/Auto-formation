package org.sid.metier;

import java.util.Date;
import org.sid.dao.CompteRepository;
import org.sid.dao.EmployeRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Compte;
import org.sid.entities.Employe;
import org.sid.entities.Operation;
import org.sid.entities.Retrait;
import org.sid.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationMetierImpl implements OperationMetier {

	@Autowired
	private OperationRepository operationRepository;
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private EmployeRepository employeRepository;
	
	@Override
	@Transactional
	public boolean verser(String code, double montant, Long codeEmp) {
		Compte cp=compteRepository.findById(code).orElse(null);
		Employe emp=employeRepository.findById(codeEmp).orElse(null);
		Operation o=new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(emp);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()+montant);
		return true;
	}

	@Override
	@Transactional
	public boolean retirer(String code, double montant, Long codeEmp) {
		Compte cp=compteRepository.findById(code).orElse(null);
		if(cp.getSolde()<montant)
		{
			throw new RuntimeException("Solde insuffisant");
		}
		Employe emp=employeRepository.findById(codeEmp).orElse(null);
		Operation o=new Retrait();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(emp);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()-montant);
		return true;
	}

	@Override
	@Transactional
	public boolean virement(String cpte1, String cpte2, double montant, Long codeEmp) {
		retirer(cpte1,montant,codeEmp);
		verser(cpte2,montant,codeEmp);
		return true;
	}

	@Override
	public PageOperation getOperations(String codeCompte, int page, int size) {
		
		Page<Operation> ops=operationRepository.getOperations(codeCompte,PageRequest.of(page, size));
		PageOperation pOp=new PageOperation();
		pOp.setOperations(ops.getContent());
		pOp.setNombreOperations(ops.getNumberOfElements());
		pOp.setPage(ops.getNumber());
		pOp.setTotalPages(ops.getTotalPages());
		pOp.setTotalOperations((int)ops.getTotalElements());
		return pOp;
	}

}
