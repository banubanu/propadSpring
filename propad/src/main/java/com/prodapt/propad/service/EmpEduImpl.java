package com.prodapt.propad.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prodapt.propad.model.PropadEmpEduDetails;

import com.prodapt.propad.repository.EmpEduRepository;

@Service
public class EmpEduImpl  implements EmpEdu{
EmpEduRepository empEduRepository;

public EmpEduImpl(EmpEduRepository empEduRepository) {
	// TODO Auto-generated constructor stub
	this.empEduRepository = empEduRepository;
}

@Override
public List<PropadEmpEduDetails> getAll() {
	// TODO Auto-generated method stub
	return empEduRepository.findAll();
}

@Override
public PropadEmpEduDetails save(PropadEmpEduDetails pee) {
	// TODO Auto-generated method stub
	System.out.println("saved ");
	return empEduRepository.save(pee);
}

	@Override
	public Integer countnull(String ed_emp_mail) {
		// TODO Auto-generated method stub
		return empEduRepository.countnull(ed_emp_mail);
	}

	@Override
	public List<PropadEmpEduDetails> getOneRow(String ed_emp_mail) {
		// TODO Auto-generated method stub
		return  empEduRepository.getOneRow(ed_emp_mail);
	}
	

}








