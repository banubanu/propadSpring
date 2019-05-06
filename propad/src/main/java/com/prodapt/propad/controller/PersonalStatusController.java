package com.prodapt.propad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/get-per-status",  method = RequestMethod.GET)
	public Integer getpersonalstatus(@RequestParam("ep_per_mail") String ep_per_mail ) {
		System.out.println(ep_per_mail);
		if(this.empPer.countnull(ep_per_mail)==null) {
			return -1;
		}
		return this.empPer.countnull(ep_per_mail);
	}
	
}
