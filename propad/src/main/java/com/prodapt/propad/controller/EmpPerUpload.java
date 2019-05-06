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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.prodapt.propad.dto.EmpTechDTO;
import com.prodapt.propad.dto.EmployeePerDTO;
import com.prodapt.propad.model.PropadEmpPerDetails;
import com.prodapt.propad.model.PropadEmpTechDetails;
import com.prodapt.propad.model.Status;
import com.prodapt.propad.repository.EmpPerRepository;
import com.prodapt.propad.service.EmpPer;


@RestController
@CrossOrigin("*")
@RequestMapping("/getper")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmpPerUpload {
	@Autowired
	EmpPer empPer;
	
	@Autowired
	EmpPerRepository empPerRepository;
	
	public EmpPerUpload(EmpPer empPer)
	{
		this.empPer = empPer;
	}
	
	
	@RequestMapping(value = "/record-exists", method = RequestMethod.GET)
    public ResponseEntity<Status> getsave(@RequestParam String ep_per_mail){
           Status status=new Status();
           List<PropadEmpPerDetails> list=empPerRepository.findByEp_per_mail(ep_per_mail);
          // List<RtSavedJobDetails> list = savedRepository.findBySjEmployeeCodeAndRtJobDetails_JdPositionCode(sjEmployeeCode, jdPositionCode);
             if(!list.isEmpty()&& list.size()>0) 
             { 
                    status.setStatusCode(200);
                    status.setPropadEmpPerDetails(list.get(0));
             }
           return new ResponseEntity<Status>(status, HttpStatus.OK);
    }
    

//	@RequestMapping(value = "/update-personal-document", method = RequestMethod.POST)
//	public PropadEmpPerDetails updatepersonaldocument(@RequestPart(required = false) Map<String, String> json, EmployeePerDTO empper, @RequestParam( required = false) MultipartFile aadhar, @RequestParam( required = false) MultipartFile passport,@RequestParam( required = false) MultipartFile pancard,@RequestParam( required = false) MultipartFile addressproof ) throws IOException, SerialException, SQLException {
//		System.out.println("hi");
//	PropadEmpPerDetails pep = new PropadEmpPerDetails();
//		pep.setEp_per_emp_id(empper.getEp_per_emp_id());
//		if(aadhar!=null) {
//			pep.setEp_per_aadhar(aadhar.getBytes());
//		}	
//		if(addressproof!=null) {
//			pep.setEp_per_aadhar(addressproof.getBytes());
//		}
//		if(pancard!=null) {
//			pep.setEp_per_pan(pancard.getBytes());
//		}
//		if(passport!=null) {
//			pep.setEp_per_aadhar(passport.getBytes());
//		}
//		pep.setEp_per_aadhar_text(empper.getEp_per_aadhar_text());
//		
//		pep.setEp_per_addressproof_text(empper.getEp_per_addressproof_text());
//		
//		pep.setEp_per_pan_text(empper.getEp_per_pan_text());
//		
//		pep.setEp_per_pp_text(empper.getEp_per_pp_text());
//		
//		return this.empPer.save(pep) ;
//	}
    
	
	@RequestMapping(value = "/upload-personal-document", method = RequestMethod.POST)
	public PropadEmpPerDetails uploadpersonaldocument(@RequestPart(required = false) Map<String, String> json, EmployeePerDTO empper, @RequestParam( required = false) MultipartFile aadhar, @RequestParam( required = false) MultipartFile passport,@RequestParam( required = false) MultipartFile pancard,@RequestParam( required = false) MultipartFile addressproof ) throws IOException, SerialException, SQLException {
//		System.out.println("personal "+file.getOriginalFilename());
//		System.out.println(file.getBytes());
//		System.out.println(emptech.getEt_tech_cert1());
		System.out.println("hi");
		
//		 RtJobDetails rtJobDetails = refTalRepository.findByJdPositionCode(save.getPositionCode());
//	       save.setRtJobDetails(rtJobDetails);
//	       RtSavedJobDetails returnSave = null;   
//		PropadEmpPerDetails pepr=empPerRepository.findByEp_per_emp_id(empper.getEp_per_emp_id());
//		System.out.println(pepr);
		
		PropadEmpPerDetails pep = new PropadEmpPerDetails();

		pep.setEp_per_emp_id(empper.getEp_per_emp_id());
		if(aadhar!=null) {
			pep.setEp_per_aadhar(aadhar.getBytes());
		}
		if(addressproof!=null) {
			pep.setEp_per_addressproof(addressproof.getBytes());
		}
		if(pancard!=null) {
			pep.setEp_per_pan(pancard.getBytes());
		}
		if(passport!=null) {
			pep.setEp_per_pp(passport.getBytes());
		}
		pep.setEp_per_aadhar_text(empper.getEp_per_aadhar_text());
		
		pep.setEp_per_addressproof_text(empper.getEp_per_addressproof_text());
		
		pep.setEp_per_pan_text(empper.getEp_per_pan_text());
		
		pep.setEp_per_pp_text(empper.getEp_per_pp_text());
		
		return this.empPer.save(pep) ;
	}

	








@RequestMapping(value = "/update-per-document", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public PropadEmpPerDetails updatepersonaldocument(@RequestPart(required = false) Map<String, String> json, EmployeePerDTO empper, @RequestParam( required = false) MultipartFile aadhar, @RequestParam( required = false) MultipartFile passport,@RequestParam( required = false) MultipartFile pancard,@RequestParam( required = false) MultipartFile addressproof ) throws IOException, SerialException, SQLException {
	System.out.println("hiii from function");
	/////////////////updated details////////////////
	PropadEmpPerDetails pep3 = new PropadEmpPerDetails();
	System.out.println("hiii from object");
	pep3.setEper_id(empper.getEper_id());
	pep3.setEp_per_emp_id(empper.getEp_per_emp_id());
	if(aadhar!=null) {
		pep3.setEp_per_aadhar(aadhar.getBytes());
	}
	if(addressproof!=null) {
		pep3.setEp_per_addressproof(addressproof.getBytes());
	}
	if(pancard!=null) {
		pep3.setEp_per_pan(pancard.getBytes());
	}
	if(passport!=null) {
		pep3.setEp_per_pp(passport.getBytes());
	}
	System.out.println("updarteed records"+pep3);
	
	
	PropadEmpPerDetails returnrecord=null;
if( pep3.getEper_id()!=0)	{
	PropadEmpPerDetails pep2 = empPerRepository.getOne(pep3.getEper_id());
	System.out.println("record in database"+pep2);
	 if (pep2.getEp_per_emp_id() == pep3.getEp_per_emp_id()) {
		 PropadEmpPerDetails pep = new PropadEmpPerDetails();
		 pep.setEper_id(pep2.getEper_id());
		 pep.setEp_per_emp_id(pep2.getEp_per_emp_id());
		 if(pep3.getEp_per_aadhar()!=null) {
			 pep.setEp_per_aadhar(pep3.getEp_per_aadhar());
		 }else
		 {
			 pep.setEp_per_aadhar(pep2.getEp_per_aadhar());
		 }
		 
		 if(pep3.getEp_per_addressproof()!=null) {
			 pep.setEp_per_addressproof(pep3.getEp_per_addressproof());
		 }else
		 {
			 pep.setEp_per_addressproof(pep2.getEp_per_addressproof());
		 }
		 if(pep3.getEp_per_pan()!=null) {
			 pep.setEp_per_pan(pep3.getEp_per_pan());
		 }else
		 {
			 pep.setEp_per_pan(pep2.getEp_per_pan());
		 }
		 if(pep3.getEp_per_pp()!=null) {
			 pep.setEp_per_pp(pep3.getEp_per_pp());
		 }else
		 {
			 pep.setEp_per_pp(pep2.getEp_per_pp());
		 }
		 		 
	 System.out.println("update of record needed");
	 returnrecord=pep;
	 System.out.println("updation done successfully");
//	 returnrecord=this.empTech.save(pet);
	 
	 
	 }
	 else
	 {
		 returnrecord=pep3;
//		 returnrecord=	 this.empTech.save(pet3);
	 }
}
return this.empPer.save(returnrecord);
}


		
		
		
}
	








	
	
	
	













