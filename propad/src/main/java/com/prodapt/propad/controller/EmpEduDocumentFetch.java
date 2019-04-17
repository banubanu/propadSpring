package com.prodapt.propad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value = "/get-edu-documents/{emp_id}", method = RequestMethod.GET)
	public List<PropadEmpEduDetails> getUsers(@PathVariable("emp_id") int emp_id) {
		System.out.println("in get");
		return this.empEdu.getOneRow(emp_id);
}
	
	@RequestMapping(value = "/vaish/", method = RequestMethod.GET)
	public Status getstatic() {
		Status status=new Status();
		status.setMessage("Educational documents");
		status.setStatusCode(200);
		return status;
	}
	
	
}
