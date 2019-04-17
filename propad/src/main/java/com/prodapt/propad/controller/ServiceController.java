package com.prodapt.propad.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.propad.dto.EmployeeDTO;
import com.prodapt.propad.model.PropadInitiateEmployee;
import com.prodapt.propad.service.ServiceApi;

@RestController
@CrossOrigin("*")
@RequestMapping("/initateemp")
public class ServiceController {
@Autowired
	ServiceApi serviceApi;

	public ServiceController(ServiceApi serviceApi) {
		// TODO Auto-generated constructor stub
		this.serviceApi = serviceApi;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public PropadInitiateEmployee getAll() {
		EmployeeDTO employee = new EmployeeDTO();
		PropadInitiateEmployee pie = new PropadInitiateEmployee();
		
		
	    pie.setIe_emp_name(employee.getIe_emp_name());
	   
		pie.setIe_emp_email(employee.getIe_emp_email());
		
		pie.setIe_emp_id(employee.getIe_emp_id());
		pie.setIe_id(employee.getIe_id());
		
		pie.setIe_int1(employee.getIe_int1());
		
		pie.setIe_int2(employee.getIe_int2());
		
		pie.setIe_status(employee.getIe_status());
		
        System.out.println(this.serviceApi.getAll());
		return this.serviceApi.save(pie);
	}
	
	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public PropadInitiateEmployee addUser(@RequestBody EmployeeDTO employee) {
		System.out.println("hi");
		System.out.println(employee.getIe_emp_name());
		PropadInitiateEmployee pie = new PropadInitiateEmployee();
		pie.setIe_emp_name(employee.getIe_emp_name());

		pie.setIe_emp_name(employee.getIe_emp_name());
        pie.setIe_emp_doj(employee.getIe_emp_doj());
        pie.setIe_emp_date(new Date());

	    pie.setIe_emp_email(employee.getIe_emp_email());
		pie.setIe_emp_id(employee.getIe_emp_id());
		pie.setIe_int1(employee.getIe_int1()); 
		pie.setIe_int2(employee.getIe_int2());
		pie.setIe_status(employee.getIe_status());
		return this.serviceApi.save(pie) ;
	}
	
	@RequestMapping(value = "/get-users", method = RequestMethod.GET)
	public List<PropadInitiateEmployee> getUsers() {
		return this.serviceApi.getAll();
	}
	
}
