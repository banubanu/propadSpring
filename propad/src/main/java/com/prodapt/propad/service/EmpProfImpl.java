package com.prodapt.propad.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.prodapt.propad.model.PropadEmpProfDetails;
import com.prodapt.propad.model.PropadEmpTechDetails;
import com.prodapt.propad.repository.EmpProfRepository;


@Service
public class EmpProfImpl implements EmpProf {
	EmpProfRepository service;
	
	public EmpProfImpl(EmpProfRepository service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	
	@Override
	public List<PropadEmpProfDetails> getAll() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

	
	@Override
	public List<PropadEmpProfDetails> getOneRow(int emp_id) {
		// TODO Auto-generated method stub
		return service.getOneRow(emp_id);
	}
	@Override
	public PropadEmpProfDetails save(PropadEmpProfDetails ppd) {
		// TODO Auto-generated method stub
		return service.save(ppd);
	}

	@Override
	public Integer countnull(int ep_emp_id) {
		// TODO Auto-generated method stub
		return service.countnull(ep_emp_id);
	}
	

}
