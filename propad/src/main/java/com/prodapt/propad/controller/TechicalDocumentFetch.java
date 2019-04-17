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
	
	
	@RequestMapping(value = "/get-all-documents/{emp_id}", method = RequestMethod.GET)
	public List<PropadEmpTechDetails> getUsers(@PathVariable("emp_id") int emp_id) {
		System.out.println("in get");
		return this.empTech.getOneRow(emp_id);
	}
	
	@RequestMapping(value = "/vaish/", method = RequestMethod.GET)
	public Status getstatic() {
		Status status=new Status();
		status.setMessage("Technical documents");
		status.setStatusCode(200);
		return status;
	}
	
//public List<Job> getDetails(@RequestParam String name)
//{
//
//    System.out.println("select DISTINCT id,jd_position_title,jd_business_unit,jd_delivery_centre,jd_position_creation_date,jd_education,jd_experience,jd_designation,jd_work_location,jd_job_responsibilities,jd_skills,jd_position_code from `refertalents`.`rt_job_details`,`refertalents`.`rt_preferred_job_details` where rt_job_details.jd_skills = rt_preferred_job_details.pj_skills and rt_preferred_job_details.pj_employee_name='"+name+"'");
//      Query query = entityManager.createNativeQuery(
//    "select DISTINCT id,jd_position_title,jd_business_unit,jd_delivery_centre,jd_position_creation_date,jd_education,jd_experience,jd_designation,jd_work_location,jd_job_responsibilities,jd_skills,jd_position_code from `refertalents`.`rt_job_details`,`refertalents`.`rt_preferred_job_details` where rt_job_details.jd_skills = rt_preferred_job_details.pj_skills and rt_preferred_job_details.pj_employee_name='"+name+"'",Job.class);
//      
//      List<Job> job = query.getResultList(); 
//      return  job; 
//}

	
}









	
	
