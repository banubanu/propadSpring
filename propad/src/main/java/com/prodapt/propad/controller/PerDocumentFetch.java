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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prodapt.propad.model.PropadEmpEduDetails;
import com.prodapt.propad.model.PropadEmpPerDetails;
import com.prodapt.propad.model.Status;
import com.prodapt.propad.repository.EmpEduRepository;
import com.prodapt.propad.service.EmpPer;

@RestController
@CrossOrigin("*")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RequestMapping("/getperdocument")
public class PerDocumentFetch {
	@Autowired
	EmpPer empPer;
	
	@PersistenceContext
    EntityManager entityManager;
	
	public PerDocumentFetch(EmpPer empPer) {
		// TODO Auto-generated constructor stub
		this.empPer = empPer;
	}
	
	@RequestMapping(value = "/get-per-documents", method = RequestMethod.GET)
	public List<PropadEmpPerDetails> getUsers(@RequestParam("ep_per_mail") String ep_per_mail) {
		System.out.println("in get");
		return this.empPer.findByEp_per_mail(ep_per_mail);
}
	
	
	@GetMapping("get-pending-documents")
    public List<PropadEmpPerDetails> getPendingDocument(@RequestParam("ep_per_mail") String ep_per_mail) {
           Query query = entityManager.createNativeQuery(
                        "select addressproof_status,aadhar_status,pan_status,pp_status from propad_emp_per_details where ep_per_mail='"+ep_per_mail+"'");
           List<PropadEmpPerDetails> pendingDocuments = query.getResultList();
           return pendingDocuments;

    }
	
}






	
	
	
	
	
	