package com.prodapt.propad.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.propad.model.PropadEmpEduDetails;
import com.prodapt.propad.model.Status;
import com.prodapt.propad.service.EmpEdu;


@RestController
@CrossOrigin("*")
@RequestMapping("/getemployeeedudetails")
public class EmpEduDocumentFetch {
	@Autowired
	EmpEdu empEdu;
	
	@PersistenceContext
    EntityManager entityManager;

	
	public EmpEduDocumentFetch(EmpEdu empEdu) {
		// TODO Auto-generated constructor stub
		this.empEdu = empEdu;
	}	
	@RequestMapping(value = "/get-edu-documents", method = RequestMethod.GET)
	public List<PropadEmpEduDetails> getUsers(@RequestParam("ed_emp_mail") String ed_emp_mail) {
		System.out.println("in get");
		System.out.println(ed_emp_mail);
		return this.empEdu.findByEd_emp_mail(ed_emp_mail);
}
	

	@GetMapping("get-pending-documents")
    public List<PropadEmpEduDetails> getPendingDocument(@RequestParam("ed_emp_mail") String ed_emp_mail) {
           Query query = entityManager.createNativeQuery(
                        "select sslc_status as sslc_status ,hsc_status as hsc_status,dip_status as dip_status,ug_status as ug_status,pg_status as pg_status from propad_emp_edu_details where ed_emp_mail='"+ed_emp_mail+"'");
           List<PropadEmpEduDetails> pendingDocuments = query.getResultList();
           return pendingDocuments;

    }



	
}
