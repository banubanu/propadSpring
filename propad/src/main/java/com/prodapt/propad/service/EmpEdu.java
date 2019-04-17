package com.prodapt.propad.service;

import java.util.List;

import com.prodapt.propad.model.PropadEmpEduDetails;


public interface EmpEdu {
	List<PropadEmpEduDetails> getAll();
	Integer countnull(Integer i);
	List<PropadEmpEduDetails> getOneRow(int emp_id);
	PropadEmpEduDetails save(PropadEmpEduDetails  pee);
	

}



