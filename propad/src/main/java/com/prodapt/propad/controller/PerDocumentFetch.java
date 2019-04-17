package com.prodapt.propad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prodapt.propad.model.PropadEmpEduDetails;
import com.prodapt.propad.model.PropadEmpPerDetails;
import com.prodapt.propad.model.Status;
import com.prodapt.propad.service.EmpPer;

@RestController
@CrossOrigin("*")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RequestMapping("/getperdocument")
public class PerDocumentFetch {
	@Autowired
	EmpPer empPer;
	public PerDocumentFetch(EmpPer empPer) {
		// TODO Auto-generated constructor stub
		this.empPer = empPer;
	}
	
	@RequestMapping(value = "/get-per-documents/{emp_id}", method = RequestMethod.GET)
	public List<PropadEmpPerDetails> getUsers(@PathVariable("emp_id") int emp_id) {
		System.out.println("in get");
		return this.empPer.getOneRow(emp_id);
}
	
	@RequestMapping(value = "/vaish/", method = RequestMethod.GET)
	public Status getstatic() {
		Status status=new Status();
		status.setMessage("Personal documents");
		status.setStatusCode(200);
		return status;
	}
}






	
	
	
	
	
	