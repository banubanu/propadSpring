package com.prodapt.propad.service;

import java.util.List;

import com.prodapt.propad.model.PropadEmpEduDetails;
import com.prodapt.propad.model.PropadEmpPerDetails;

public interface EmpPer {
	
	List<PropadEmpPerDetails> getAll();
	List<PropadEmpPerDetails> getOneRow(int emp_id);
	Integer countnull(int ep_per_emp_id);
	PropadEmpPerDetails save(PropadEmpPerDetails  pep);
	
	
	
	
	

}
