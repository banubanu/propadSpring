package com.prodapt.propad.service;
import java.util.List;


import com.prodapt.propad.model.PropadEmpTechDetails;

public interface EmpTech {

	Integer countnull(Integer i);
	List<PropadEmpTechDetails> getOneRow(int emp_id);
	List<PropadEmpTechDetails> getAll();
	PropadEmpTechDetails save(PropadEmpTechDetails  pet);
	PropadEmpTechDetails update(PropadEmpTechDetails  pet);

}






