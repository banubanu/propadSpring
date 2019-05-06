package com.prodapt.propad.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prodapt.propad.model.PropadEmpTechDetails;
import com.prodapt.propad.model.Status;
import com.prodapt.propad.service.EmpTech;


@RestController
@CrossOrigin("*")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RequestMapping("/gettechdocument")
public class TechicalDocumentFetch {

	
	@Autowired
	EmpTech empTech;
	public TechicalDocumentFetch(EmpTech empTech) {
		// TODO Auto-generated constructor stub
		this.empTech = empTech;
	}
	
	
	@RequestMapping(value = "/get-all-documents", method = RequestMethod.GET)
	public List<PropadEmpTechDetails> getUsers(@RequestParam("et_emp_mail") String et_emp_mail) {
		System.out.println("in get");
		return this.empTech.getOneRow(et_emp_mail);
	}
	
	
	
	
	


	
}









	
	
