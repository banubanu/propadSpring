package com.prodapt.propad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prodapt.propad.service.EmpPer;

@RestController
@CrossOrigin("*")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RequestMapping("/getstatus")
public class PersonalStatusController {
	@Autowired
	EmpPer empPer;
	public PersonalStatusController(EmpPer empPer) {
		// TODO Auto-generated constructor stub
		this.empPer = empPer;
	}
	
	@RequestMapping(value = "/get-per-status/{ep_per_emp_id}", method = RequestMethod.GET)
	public Integer getpersonalstatus(@PathVariable("ep_per_emp_id") int ep_per_emp_id ) {
		if(this.empPer.countnull(ep_per_emp_id)==null) {
			return -1;
		}
		return this.empPer.countnull(ep_per_emp_id);
	}
	
}
