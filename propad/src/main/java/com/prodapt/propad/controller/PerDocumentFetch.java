package com.prodapt.propad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/get-per-documents/{ep_per_mail}", method = RequestMethod.GET)
	public List<PropadEmpPerDetails> getUsers(@RequestParam("ep_per_mail") String ep_per_mail) {
		System.out.println("in get");
		return this.empPer.getOneRow(ep_per_mail);
}
	
	
}






	
	
	
	
	
	