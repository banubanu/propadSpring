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
import com.prodapt.propad.model.PropadEmpPerDetails;
import com.prodapt.propad.model.PropadEmpTechDetails;
import com.prodapt.propad.model.Status;
import com.prodapt.propad.repository.EmpTechRepository;
import com.prodapt.propad.service.EmpTech;

@RestController
@CrossOrigin("*")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RequestMapping("/uploadtechdocuments")
public class TechincalDocumentUpload {
		
		@Autowired
		EmpTech empTech;
		@Autowired
		EmpTechRepository empTechRepository;
		
		public TechincalDocumentUpload(EmpTech empTech) {
			// TODO Auto-generated constructor stub
			this.empTech = empTech;
		}
		
		@RequestMapping(value = "/record-exists", method = RequestMethod.GET)
	    public ResponseEntity<Status> getsave(@RequestParam Integer et_emp_id){
	           Status status=new Status();
	           List<PropadEmpTechDetails> list=empTechRepository.findByEt_emp_id(et_emp_id);
	          // List<RtSavedJobDetails> list = savedRepository.findBySjEmployeeCodeAndRtJobDetails_JdPositionCode(sjEmployeeCode, jdPositionCode);
	             if(!list.isEmpty()&& list.size()>0) 
	             { 
	                    status.setStatusCode(200);
	                    status.setPropadEmpTechDetails(list.get(0));
	             }
	           return new ResponseEntity<Status>(status, HttpStatus.OK);
	    }
	
	@RequestMapping(value = "/upload-tech-document", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public PropadEmpTechDetails uploaddocumentModel( @RequestPart(required = false) Map<String, String> json, EmpTechDTO emptech, @RequestParam("file") MultipartFile file, @RequestParam(required = false) MultipartFile file1,@RequestParam(required = false) MultipartFile file2,@RequestParam(required = false) MultipartFile file3,@RequestParam(required = false) MultipartFile file4) throws IOException, SerialException, SQLException {
		System.out.println("test"+file.getOriginalFilename());
		System.out.println(file.getBytes());
//		System.out.println(emptech.getEt_tech_cert1());
		
	PropadEmpTechDetails pet = new PropadEmpTechDetails();
//  pet.setEt_tech_cert1(((EmpTechDTO) file).getEt_tech_cert1());
//	pet.setEt_emp_id(et_emp_id);
	pet.setEt_emp_id(emptech.getEt_emp_id());
	if(file!=null) {
		pet.setEt_tech_cert1(file.getBytes());
	}
	
		
		if(file1!=null) {
			pet.setEt_tech_cert2(file1.getBytes());
		}
        
       
        if(file2!=null) {
        	pet.setEt_tech_cert3(file2.getBytes());
		}

       
        if(file3!=null) {
        	pet.setEt_tech_cert4(file3.getBytes());
       }
        if(file4!=null) {
        	pet.setEt_tech_cert5(file4.getBytes());
		}
        
        pet.setEt_tech_cert1_text(emptech.getEt_tech_cert1_text());
        pet.setEt_tech_cert2_text(emptech.getEt_tech_cert2_text());
        pet.setEt_tech_cert3_text(emptech.getEt_tech_cert3_text());
        pet.setEt_tech_cert4_text(emptech.getEt_tech_cert4_text());
        pet.setEt_tech_cert5_text(emptech.getEt_tech_cert5_text());
        pet.setEt_tech_comments(emptech.getEt_tech_comments());
		return this.empTech.save(pet) ;
	}
	
	
	
	
//    
//    @PostMapping("savejobdetails")
//    public RtSavedJobDetails savejdobed(@RequestBody RtSavedJobDetails save) {
//           RtJobDetails rtJobDetails = refTalRepository.findByJdPositionCode(save.getPositionCode());
//           save.setRtJobDetails(rtJobDetails);
//           RtSavedJobDetails returnSave = null;
//           if (save.getId() != 0) {
//                  RtSavedJobDetails save2 = savedRepository.getOne(save.getId());
//                  if (save2.getSjEmployeeCode() != save.getSjEmployeeCode()) {
//                        RtSavedJobDetails save3 = new RtSavedJobDetails();
//                        save3.setSjEmployeeCode(save.getSjEmployeeCode());
//                        save3.setRtJobDetails(rtJobDetails);
//                         save3.setPositionCode(save.getPositionCode());
//                        save3.setSjSaveFlag(save.isSjSaveFlag());
//                        returnSave = savedRepository.save(save3);
//                  } else {
//                        returnSave = savedRepository.save(save);
//                  }
//
//           } else {
//                  returnSave = savedRepository.save(save);
//           }
//
//           return returnSave;
//
//    }

	}







	
	
	
	