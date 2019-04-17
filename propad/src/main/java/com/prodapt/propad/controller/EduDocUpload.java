package com.prodapt.propad.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prodapt.propad.dto.EmpTechDTO;
import com.prodapt.propad.dto.EmployeeEduDTO;
import com.prodapt.propad.model.PropadEmpEduDetails;
import com.prodapt.propad.model.PropadEmpPerDetails;
import com.prodapt.propad.model.PropadEmpTechDetails;
import com.prodapt.propad.model.Status;
import com.prodapt.propad.repository.EmpEduRepository;
import com.prodapt.propad.service.EmpEdu;
import com.prodapt.propad.service.EmpTech;


@RestController
@CrossOrigin("*")
@RequestMapping("/uploadedudocuments")
public class EduDocUpload {
	@Autowired
	EmpEdu empEdu;
	@Autowired
	EmpEduRepository empEduRepository;
	
	public EduDocUpload(EmpEdu empEdu) {
		// TODO Auto-generated constructor stub
		this.empEdu = empEdu;
	}
	
	@RequestMapping(value = "/record-exists", method = RequestMethod.GET)
    public ResponseEntity<Status> getsave(@RequestParam Integer ed_emp_id){
           Status status=new Status();
           List<PropadEmpEduDetails> list=empEduRepository.findByEd_emp_id(ed_emp_id);
          // List<RtSavedJobDetails> list = savedRepository.findBySjEmployeeCodeAndRtJobDetails_JdPositionCode(sjEmployeeCode, jdPositionCode);
             if(!list.isEmpty()&& list.size()>0) 
             { 
                    status.setStatusCode(200);
                    status.setPropadEmpEduDetails(list.get(0));
             }
           return new ResponseEntity<Status>(status, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/upload-edu-document", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public PropadEmpEduDetails uploadedudocument( @RequestPart(required = false) Map<String, String> json,EmployeeEduDTO empEdu, @RequestParam("file") MultipartFile file, @RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2,@RequestParam("file3") MultipartFile file3,@RequestParam("file4") MultipartFile file4, @RequestParam("file5") MultipartFile file5) throws IOException, SerialException, SQLException {
		System.out.println("banu"+file.getOriginalFilename());
		System.out.println(file.getBytes());
//		System.out.println(emptech.getEt_tech_cert1());
		
		PropadEmpEduDetails pee = new PropadEmpEduDetails();
//  pet.setEt_tech_cert1(((EmpTechDTO) file).getEt_tech_cert1());
//	pet.setEt_emp_id(et_emp_id);
		
		pee.setEd_emp_id(empEdu.getEd_emp_id());
	
		pee.setEd_edu_sslc(file.getBytes());
		
		pee.setEd_edu_sslc_text(empEdu.getEd_edu_sslc_text());
		
        pee.setEd_edu_hsc(file1.getBytes());
       
        pee.setEd_edu_hsc_text(empEdu.getEd_edu_hsc_text());
        pee.setEd_edu_dip(file2.getBytes());
        pee.setEd_edu_dip_text(empEdu.getEd_edu_dip_text());
        pee.setEd_edu_ug(file3.getBytes());
        pee.setEd_edu_ug_text(empEdu.getEd_edu_ug_text());
        pee.setEd_edu_pg(file4.getBytes());
        
        pee.setEd_edu_pg_text(empEdu.getEd_edu_pg_text());
        pee.setEd_edu_others(file5.getBytes());
      
        pee.setEd_edu_others_text(empEdu.getEd_edu_others_text());
        pee.setEd_edu_comments(empEdu.getEd_edu_comments());
       
		return this.empEdu.save(pee) ;
	}

}






		
		
		
	

