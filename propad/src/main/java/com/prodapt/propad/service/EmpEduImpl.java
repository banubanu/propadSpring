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
	public Integer countnull(Integer i) {
		// TODO Auto-generated method stub
		return empEduRepository.countnull(i);
	}

	@Override
	public List<PropadEmpEduDetails> getOneRow(int emp_id) {
		// TODO Auto-generated method stub
		return  empEduRepository.getOneRow(emp_id);
	}
	

}








