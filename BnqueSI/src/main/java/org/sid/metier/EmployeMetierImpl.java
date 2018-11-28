package org.sid.metier;

import java.util.List;

import org.sid.dao.EmployeRepository;
import org.sid.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeMetierImpl implements EmployeMetier{

	@Autowired
	EmployeRepository employeRepository;
	
	@Override
	public Employe saveEmploye(Employe e) {
		return this.employeRepository.save(e);
	}

	@Override
	public List<Employe> listEmployes() {
		// TODO Auto-generated method stub
		return this.employeRepository.findAll();
	}

}
