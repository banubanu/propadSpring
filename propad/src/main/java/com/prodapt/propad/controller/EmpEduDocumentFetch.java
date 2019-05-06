package com.prodapt.propad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	public EmpEduDocumentFetch(EmpEdu empEdu) {
		// TODO Auto-generated constructor stub
		this.empEdu = empEdu;
	}	
	@RequestMapping(value = "/get-edu-documents", method = RequestMethod.GET)
	public List<PropadEmpEduDetails> getUsers(@RequestParam("ed_emp_mail") String ed_emp_mail) {
		System.out.println("in get");
		System.out.println(ed_emp_mail);
		return this.empEdu.getOneRow(ed_emp_mail);
}
	
	
	
	
}
