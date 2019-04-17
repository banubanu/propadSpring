package com.prodapt.propad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.prodapt.propad.model.PropadEmpProfDetails;
import com.prodapt.propad.model.Status;
import com.prodapt.propad.repository.EmpProfRepository;
import com.prodapt.propad.service.EmpProf;


@RestController
@CrossOrigin("*")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RequestMapping("/getprofdocument")
public class ProfDocumentFetch {
	@Autowired
	EmpProf empProf;
	@Autowired
	EmpProfRepository empProfRepository;
	
	public ProfDocumentFetch(EmpProf empProf) {
		// TODO Auto-generated constructor stub
		this.empProf = empProf;
	}
	
    
	
	@RequestMapping(value = "/get-prof-documents/{emp_id}", method = RequestMethod.GET)
	public List<PropadEmpProfDetails> getUsers(@PathVariable("emp_id") int emp_id) {
		System.out.println("in get");
		return this.empProf.getOneRow(emp_id);
}
	
	@RequestMapping(value = "/vaish/", method = RequestMethod.GET)
	public Status getstatic() {
		Status status=new Status();
		status.setMessage("Professional documents");
		status.setStatusCode(200);
		return status;
	}
}
