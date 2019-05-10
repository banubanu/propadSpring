package com.prodapt.propad.service;

import java.util.List;

import com.prodapt.propad.model.PropadEmpProfDetails;



public interface EmpProf {
	List<PropadEmpProfDetails> getAll();
	Integer countnull(String ep_prof_mail);
	List<PropadEmpProfDetails> getOneRow(String ep_prof_mail);
	PropadEmpProfDetails save(PropadEmpProfDetails  ppd);
	List<PropadEmpProfDetails> getByEp_prof_mail(String ep_prof_mail);
	


}
