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
import com.prodapt.propad.dto.EmpTechDTO;
import com.prodapt.propad.dto.EmployeePerDTO;
import com.prodapt.propad.model.PropadEmpPerDetails;
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
    public ResponseEntity<Status> getsave(@RequestParam Integer ep_per_emp_id){
           Status status=new Status();
           List<PropadEmpPerDetails> list=empPerRepository.findByEp_per_emp_id(ep_per_emp_id);
          // List<RtSavedJobDetails> list = savedRepository.findBySjEmployeeCodeAndRtJobDetails_JdPositionCode(sjEmployeeCode, jdPositionCode);
             if(!list.isEmpty()&& list.size()>0) 
             { 
                    status.setStatusCode(200);
                    status.setPropadEmpPerDetails(list.get(0));
             }
           return new ResponseEntity<Status>(status, HttpStatus.OK);
    }
    

	@RequestMapping(value = "/update-personal-document", method = RequestMethod.PATCH)
	public PropadEmpPerDetails updatepersonaldocument(@RequestPart(required = false) Map<String, String> json, EmployeePerDTO empper, @RequestParam( required = false) MultipartFile aadhar, @RequestParam( required = false) MultipartFile passport,@RequestParam( required = false) MultipartFile pancard,@RequestParam( required = false) MultipartFile addressproof ) throws IOException, SerialException, SQLException {
		System.out.println("hi");
	PropadEmpPerDetails pep = new PropadEmpPerDetails();
		pep.setEp_per_emp_id(empper.getEp_per_emp_id());
		if(aadhar!=null) {
			pep.setEp_per_aadhar(aadhar.getBytes());
		}	
		if(addressproof!=null) {
			pep.setEp_per_aadhar(addressproof.getBytes());
		}
		if(pancard!=null) {
			pep.setEp_per_pan(pancard.getBytes());
		}
		if(passport!=null) {
			pep.setEp_per_aadhar(passport.getBytes());
		}
		pep.setEp_per_aadhar_text(empper.getEp_per_aadhar_text());
		
		pep.setEp_per_addressproof_text(empper.getEp_per_addressproof_text());
		
		pep.setEp_per_pan_text(empper.getEp_per_pan_text());
		
		pep.setEp_per_pp_text(empper.getEp_per_pp_text());
		
		return this.empPer.save(pep) ;
	}
    
	
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
			pep.setEp_per_aadhar(addressproof.getBytes());
		}
		if(pancard!=null) {
			pep.setEp_per_pan(pancard.getBytes());
		}
		if(passport!=null) {
			pep.setEp_per_aadhar(passport.getBytes());
		}
		pep.setEp_per_aadhar_text(empper.getEp_per_aadhar_text());
		
		pep.setEp_per_addressproof_text(empper.getEp_per_addressproof_text());
		
		pep.setEp_per_pan_text(empper.getEp_per_pan_text());
		
		pep.setEp_per_pp_text(empper.getEp_per_pp_text());
		
		return this.empPer.save(pep) ;
	}

	
	

}







//@PostMapping("savejobdetails")
//public RtSavedJobDetails savejdobed(@RequestBody RtSavedJobDetails save) {
//       RtJobDetails rtJobDetails = refTalRepository.findByJdPositionCode(save.getPositionCode());
//       save.setRtJobDetails(rtJobDetails);
//       RtSavedJobDetails returnSave = null;
//       if (save.getId() != 0) {
//              RtSavedJobDetails save2 = savedRepository.getOne(save.getId());
//              if (save2.getSjEmployeeCode() != save.getSjEmployeeCode()) {
//                    RtSavedJobDetails save3 = new RtSavedJobDetails();
//                    save3.setSjEmployeeCode(save.getSjEmployeeCode());
//                    save3.setRtJobDetails(rtJobDetails);
//                     save3.setPositionCode(save.getPositionCode());
//                    save3.setSjSaveFlag(save.isSjSaveFlag());
//                    returnSave = savedRepository.save(save3);
//              } else {
//                    returnSave = savedRepository.save(save);
//              }
//
//       } else {
//              returnSave = savedRepository.save(save);
//       }
//
//       return returnSave;
//
//}


		
		
		
		
	








	
	
	
	













