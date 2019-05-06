package com.prodapt.propad.service;

import java.util.List;

import com.prodapt.propad.model.PropadEmpEduDetails;
import com.prodapt.propad.model.PropadEmpPerDetails;

public interface EmpPer {
	
	List<PropadEmpPerDetails> getAll();
	List<PropadEmpPerDetails> getOneRow(String ep_per_mail);
	Integer countnull(String ep_per_mail);
	PropadEmpPerDetails save(PropadEmpPerDetails  pep);
	
	
	
	
	

}
