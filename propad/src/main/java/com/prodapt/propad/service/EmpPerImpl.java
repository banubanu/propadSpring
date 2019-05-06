package com.prodapt.propad.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prodapt.propad.model.PropadEmpEduDetails;
import com.prodapt.propad.model.PropadEmpPerDetails;
import com.prodapt.propad.repository.EmpPerRepository;


@Service
public class EmpPerImpl implements EmpPer {
	EmpPerRepository empPerRepo;
	
	public EmpPerImpl(EmpPerRepository empPerRepo) {
		// TODO Auto-generated constructor stub\
		System.out.println("const");
		
		this.empPerRepo = empPerRepo;
	}
	
	@Override
	public List<PropadEmpPerDetails> getAll() {
		// TODO Auto-generated method stub
		System.out.println("get");
		
		return empPerRepo.findAll();
	}

	@Override
	public PropadEmpPerDetails save(PropadEmpPerDetails pep) {
		// TODO Auto-generated method stub
		System.out.println("saved");
		
		return empPerRepo.save(pep);
	}

	@Override
	public List<PropadEmpPerDetails> getOneRow(String ep_per_mail) {
		// TODO Auto-generated method stub
		return empPerRepo.getOneRow(ep_per_mail);
	}

	@Override
	public Integer countnull(String ep_per_mail) {
		// TODO Auto-generated method stub
		return empPerRepo.countnull(ep_per_mail);
	}

	
	


}
