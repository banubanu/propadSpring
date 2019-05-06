package com.prodapt.propad.service;

import java.util.List;

import com.prodapt.propad.model.PropadEmpEduDetails;


public interface EmpEdu {
	List<PropadEmpEduDetails> getAll();
	Integer countnull(String ed_emp_mail);
	List<PropadEmpEduDetails> getOneRow(String ed_emp_mail);
	PropadEmpEduDetails save(PropadEmpEduDetails  pee);
	

}



