package com.prodapt.propad.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prodapt.propad.model.PropadEmpTechDetails;
import com.prodapt.propad.repository.EmpTechRepository;

@Service
public class EmpTechImpl  implements EmpTech{
EmpTechRepository empTechRepository;

public EmpTechImpl(EmpTechRepository empTechRepository) {
	// TODO Auto-generated constructor stub
	this.empTechRepository = empTechRepository;
}


	@Override
	public List<PropadEmpTechDetails> getAll() {
		// TODO Auto-generated method stub
		return empTechRepository.findAll();
	}

	@Override
	public Integer countnull(String et_emp_mail) {
		// TODO Auto-generated method stub
		return empTechRepository.countnull(et_emp_mail);
	}
	@Override
	public PropadEmpTechDetails save(PropadEmpTechDetails pet) {
		// TODO Auto-generated method stub
		return empTechRepository.save(pet);
	}


//	@Override
//	public List<PropadEmpTechDetails> getAll(int emp_id) {
//		// TODO Auto-generated method stub
//		return (List<PropadEmpTechDetails>) empTechRepository.getOne(emp_id);
//	}


	@Override
	public List<PropadEmpTechDetails> getOneRow(String et_emp_mail) {
		// TODO Auto-generated method stub
		return empTechRepository.getOneRow(et_emp_mail);
	}


	@Override
	public PropadEmpTechDetails update(PropadEmpTechDetails pet) {
		// TODO Auto-generated method stub
		return empTechRepository.update(pet);
	}


	

	

}







