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
import com.prodapt.propad.dto.EmployeeProfDTO;
import com.prodapt.propad.model.PropadEmpEduDetails;
import com.prodapt.propad.model.PropadEmpPerDetails;
import com.prodapt.propad.model.PropadEmpProfDetails;
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
    public ResponseEntity<Status> getsave(@RequestParam int ie_id){
           Status status=new Status();
           List<PropadEmpPerDetails> list=empPerRepository.findByIe_id(ie_id);
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
		pep.setIe_id(empper.getIe_id());

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
		
		
		
		pep.setEp_per_mail(empper.getEp_per_mail());
		pep.setAadhar_status("Submitted");
		pep.setPan_status("Submitted");
		pep.setAddressproof_status("Submitted");
		pep.setPp_status("Submitted");
		
		
		return this.empPer.save(pep) ;
	}

	








@RequestMapping(value = "/update-per-document", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public PropadEmpPerDetails updatepersonaldocument(@RequestPart(required = false) Map<String, String> json, EmployeePerDTO empper, @RequestParam( required = false) MultipartFile aadhar, @RequestParam( required = false) MultipartFile passport,@RequestParam( required = false) MultipartFile pancard,@RequestParam( required = false) MultipartFile addressproof ) throws IOException, SerialException, SQLException {
	System.out.println("hiii from function");
	/////////////////updated details////////////////
	PropadEmpPerDetails pep3 = new PropadEmpPerDetails();
	System.out.println("hiii from object");
	pep3.setEper_id(empper.getEper_id());
	pep3.setIe_id(empper.getIe_id());
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
		 pep.setIe_id(pep2.getIe_id());
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


@RequestMapping(value = "/update-per-status", method = RequestMethod.POST)
public PropadEmpPerDetails updatepersonaldocument(@RequestBody EmployeePerDTO empper) {
	System.out.println("hiii from function");
	/////////////////updated details////////////////
	PropadEmpPerDetails ppd3 = new PropadEmpPerDetails();
	System.out.println("hiii from object");
	ppd3.setEper_id(empper.getEper_id());
	ppd3.setEp_per_mail(empper.getEp_per_mail());
	ppd3.setAadhar_status(empper.getAadhar_status());
	ppd3.setPan_status(empper.getPan_status());
	ppd3.setAddressproof_status(empper.getAddressproof_status());
	ppd3.setPp_status(empper.getPp_status());
	
	System.out.println("updarteed records"+ppd3);
	
	
	PropadEmpPerDetails returnrecord=null;
if( ppd3.getEp_per_mail()!=null)	{
	PropadEmpPerDetails ppd2 = empPerRepository.getOne(ppd3.getEper_id());
	System.out.println("record in database"+ppd2);
	 if (ppd2.getEp_per_mail().equals( ppd3.getEp_per_mail())){
		 PropadEmpPerDetails ppd = new PropadEmpPerDetails();
		 ppd.setEper_id(ppd2.getEper_id());
		 ppd.setEp_per_pan(ppd2.getEp_per_pan());
		 ppd.setEp_per_addressproof(ppd2.getEp_per_pan());
		 ppd.setEp_per_aadhar(ppd2.getEp_per_aadhar());
		 ppd.setEp_per_pp(ppd2.getEp_per_pp());
		 ppd.setEp_per_mail(ppd2.getEp_per_mail());
		ppd.setAadhar_status(ppd3.getAadhar_status());
		ppd.setPan_status(ppd3.getPan_status());
		ppd.setAddressproof_status(ppd3.getAddressproof_status());
		ppd.setPp_status(ppd3.getPp_status());
		 
		
		 
	 System.out.println("update of record needed");
	 returnrecord=ppd;
	 System.out.println("updation done successfully");
 }
	 else
	 {
		 returnrecord=ppd3;
	 }
}
return this.empPer.save(returnrecord);
}		
		
		
}
	








	
	
	
	













