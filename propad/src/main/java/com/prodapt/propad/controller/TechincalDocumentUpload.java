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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.core.JsonParseException;
import com.prodapt.propad.dto.EmpTechDTO;
import com.prodapt.propad.model.PropadEmpPerDetails;
import com.prodapt.propad.model.PropadEmpTechDetails;
import com.prodapt.propad.model.Status;
import com.prodapt.propad.repository.EmpTechRepository;
import com.prodapt.propad.service.EmpTech;

@Controller
@RestController
@CrossOrigin("*")
@JsonIgnoreType

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
        System.out.println("testing "+ emptech.getEt_id());
        pet.setEt_tech_cert1_text(emptech.getEt_tech_cert1_text());
        pet.setEt_tech_cert2_text(emptech.getEt_tech_cert2_text());
        pet.setEt_tech_cert3_text(emptech.getEt_tech_cert3_text());
        pet.setEt_tech_cert4_text(emptech.getEt_tech_cert4_text());
        pet.setEt_tech_cert5_text(emptech.getEt_tech_cert5_text());
        pet.setEt_tech_comments(emptech.getEt_tech_comments());
		return this.empTech.save(pet) ;
	}
	
	
	
	
	@RequestMapping(value = "/update-tech-document", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public PropadEmpTechDetails updatedocumentModel( @RequestPart(required = false) Map<String, String> json, EmpTechDTO emptech, @RequestParam("file") MultipartFile file, @RequestParam(required = false) MultipartFile file1,@RequestParam(required = false) MultipartFile file2,@RequestParam(required = false) MultipartFile file3,@RequestParam(required = false) MultipartFile file4) throws IOException, SerialException, SQLException,JsonParseException {
		System.out.println("hiii from function");
		/////////////////updated details////////////////
		PropadEmpTechDetails pet3 = new PropadEmpTechDetails();
		System.out.println("hiii from object");
		pet3.setEt_id(emptech.getEt_id());
		pet3.setEt_emp_id(emptech.getEt_emp_id());
		if(file!=null) {
			pet3.setEt_tech_cert1(file.getBytes());
		}
		
			if(file1!=null) {
				pet3.setEt_tech_cert2(file1.getBytes());
			}
	        
	       
	        if(file2!=null) {
	        	pet3.setEt_tech_cert3(file2.getBytes());
			}

	       
	        if(file3!=null) {
	        	pet3.setEt_tech_cert4(file3.getBytes());
	       }
	        if(file4!=null) {
	        	pet3.setEt_tech_cert5(file4.getBytes());
			}
		
		System.out.println("updarteed records"+pet3);
		
		
PropadEmpTechDetails returnrecord=null;
	if( pet3.getEt_id()!=0)	{
		PropadEmpTechDetails pet2 = empTechRepository.getOne(pet3.getEt_id());
		System.out.println("record in database"+pet2);
		 if (pet2.getEt_emp_id() == pet3.getEt_emp_id()) {
			 PropadEmpTechDetails pet = new PropadEmpTechDetails();
			 pet.setEt_id(pet2.getEt_id());
			 pet.setEt_emp_id(pet2.getEt_emp_id());
			 if(pet3.getEt_tech_cert1()!=null) {
				 pet.setEt_tech_cert1(pet3.getEt_tech_cert1());
			 }else
			 {
				 pet.setEt_tech_cert1(pet2.getEt_tech_cert1());
			 }
			 if(pet3.getEt_tech_cert2()!=null) {
				 pet.setEt_tech_cert2(pet3.getEt_tech_cert2());
			 }else
			 {
				 pet.setEt_tech_cert2(pet2.getEt_tech_cert2());
			 }
			 if(pet3.getEt_tech_cert3()!=null) {
				 pet.setEt_tech_cert3(pet3.getEt_tech_cert3());
			 }else
			 {
				 pet.setEt_tech_cert3(pet2.getEt_tech_cert3());
			 }
			 if(pet3.getEt_tech_cert4()!=null) {
				 pet.setEt_tech_cert4(pet3.getEt_tech_cert4());
			 }else
			 {
				 pet.setEt_tech_cert4(pet2.getEt_tech_cert4());
			 }
			 if(pet3.getEt_tech_cert5()!=null) {
				 pet.setEt_tech_cert5(pet3.getEt_tech_cert5());
			 }else
			 {
				 pet.setEt_tech_cert5(pet2.getEt_tech_cert5());
			 }
			 
		 System.out.println("update of record needed");
		 returnrecord=pet;
		 System.out.println("updation done successfully");
//		 returnrecord=this.empTech.save(pet);
		 
		 
		 }
		 else
		 {
			 returnrecord=pet3;
//			 returnrecord=	 this.empTech.save(pet3);
		 }
	}
	return this.empTech.save(returnrecord);
		 
//		System.out.println("hi"+pet2);
//		System.out.println(pet3);
//		PropadEmpTechDetails pet = new PropadEmpTechDetails();
//		if(file!=null) {
//			pet.setEt_tech_cert1(file.getBytes());
//		}
//		
//			if(file1!=null) {
//				pet.setEt_tech_cert2(file1.getBytes());
//			}
//	        
//	       
//	        if(file2!=null) {
//	        	pet.setEt_tech_cert3(file2.getBytes());
//			}
//
//	       
//	        if(file3!=null) {
//	        	pet.setEt_tech_cert4(file3.getBytes());
//	       }
//	        if(file4!=null) {
//	        	pet.setEt_tech_cert5(file4.getBytes());
//			}
//	        System.out.println("hiii pet");
//       returnrecord = empTechRepository.save(pet);
//      
// } else {
//	 System.out.println("hiii pet2");
//	 returnrecord = empTechRepository.save(pet2);
//	 
// }
//
//} else {
//	System.out.println("hiii pet3");
//	returnrecord = empTechRepository.save(pet3);
//	 
//}
//System.out.println("errr");
//return returnrecord;
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





	
	
	
	