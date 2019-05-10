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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.prodapt.propad.dto.EmpTechDTO;
import com.prodapt.propad.dto.EmployeeEduDTO;
import com.prodapt.propad.dto.EmployeeProfDTO;
import com.prodapt.propad.model.PropadEmpEduDetails;
import com.prodapt.propad.model.PropadEmpProfDetails;
import com.prodapt.propad.model.PropadEmpTechDetails;
import com.prodapt.propad.model.Status;
import com.prodapt.propad.repository.EmpProfRepository;
import com.prodapt.propad.service.EmpProf;


@RestController
@CrossOrigin("*")
@RequestMapping("/getemployeeprofessionaldetails")
public class EmpProfUpload {
	@Autowired
	
	EmpProf empProf;
	@Autowired
	EmpProfRepository empProfRepository;
	
	public EmpProfUpload(EmpProf empProf)
	{
		this.empProf = empProf;
	}

	@RequestMapping(value = "/record-exists", method = RequestMethod.GET)
    public ResponseEntity<Status> getsave(@RequestParam String ep_prof_mail){
           Status status=new Status();
           List<PropadEmpProfDetails> list=empProfRepository.findByEp_prof_mail(ep_prof_mail);
          // List<RtSavedJobDetails> list = savedRepository.findBySjEmployeeCodeAndRtJobDetails_JdPositionCode(sjEmployeeCode, jdPositionCode);
             if(!list.isEmpty()&& list.size()>0) 
             { 
                    status.setStatusCode(200);
                    status.setPropadEmpProfDetails(list.get(0));
             }
           return new ResponseEntity<Status>(status, HttpStatus.OK);
    }
	
	
	@RequestMapping(value = "/upload-prof-document", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public PropadEmpProfDetails uploaddocumentModel( @RequestPart(required = false) Map<String, String> json, EmployeeProfDTO empProf, @RequestParam("file") MultipartFile file, @RequestParam(required = false) MultipartFile file1,@RequestParam(required = false) MultipartFile file2,@RequestParam(required = false) MultipartFile file3,@RequestParam(required = false) MultipartFile file4, @RequestParam(required = false) MultipartFile file5) throws IOException, SerialException, SQLException {
		System.out.println("test"+file.getOriginalFilename());
		System.out.println(file.getBytes());
//		System.out.println(emptech.getEt_tech_cert1());
		
		PropadEmpProfDetails ppd = new PropadEmpProfDetails();
//  pet.setEt_tech_cert1(((EmpTechDTO) file).getEt_tech_cert1());
//	pet.setEt_emp_id(et_emp_id);
		System.out.println("hiii from object");
		ppd.setEp_prof_mail(empProf.getEp_prof_mail());
		
		if(file!=null) {
			ppd.setEp_service_cert1(file.getBytes());
		}
		
			if(file1!=null) {
				ppd.setEp_service_cert2(file1.getBytes());
			}
	        
	       
	        if(file2!=null) {
	        	ppd.setEp_service_cert3(file2.getBytes());
			}

	       
	        if(file3!=null) {
	        	ppd.setEp_payslip1(file3.getBytes());
	       }
	        if(file4!=null) {
	        	ppd.setEp_payslip2(file4.getBytes());
			}
	        if(file5!=null) {
	        	ppd.setEp_payslip3(file5.getBytes());
			}
		
		ppd.setEp_service_cert2_text(empProf.getEp_service_cert2_text());
		
		ppd.setEp_service_cert3_text(empProf.getEp_service_cert3_text());
		
		ppd.setEp_payslip1_text(empProf.getEp_payslip1_text());
		
		ppd.setEp_payslip2_text(empProf.getEp_payslip2_text());
		
		ppd.setEp_payslip3_text(empProf.getEp_payslip3_text());
		System.out.println("hiii fro444m object");
		return this.empProf.save(ppd) ;
	}

	@RequestMapping(value = "/update-prof-document", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public PropadEmpProfDetails updatedocumentModel( @RequestPart(required = false) Map<String, String> json, EmployeeProfDTO empProf, @RequestParam("file") MultipartFile file, @RequestParam(required = false) MultipartFile file1,@RequestParam(required = false) MultipartFile file2,@RequestParam(required = false) MultipartFile file3,@RequestParam(required = false) MultipartFile file4, @RequestParam(required = false) MultipartFile file5) throws IOException, SerialException, SQLException {
	System.out.println("hiii from function");
		/////////////////updated details////////////////
	PropadEmpProfDetails ppd3 = new PropadEmpProfDetails();
		System.out.println("hiii from object");
		ppd3.setEp_id(empProf.getEp_id());
		ppd3.setEp_prof_mail(empProf.getEp_prof_mail());
		if(file!=null) {
			ppd3.setEp_service_cert1(file.getBytes());
		}
		
			if(file1!=null) {
				ppd3.setEp_service_cert2(file1.getBytes());
			}
	        
	       
	        if(file2!=null) {
	        	ppd3.setEp_service_cert3(file2.getBytes());
			}

	       
	        if(file3!=null) {
	        	ppd3.setEp_payslip1(file3.getBytes());
	       }
	        if(file4!=null) {
	        	ppd3.setEp_payslip2(file4.getBytes());
			}
	        if(file5!=null) {
	        	ppd3.setEp_payslip3(file5.getBytes());
			}
		System.out.println("updarteed records"+ppd3);
		
		
		PropadEmpProfDetails returnrecord=null;
	if( ppd3.getEp_id()!=0)	{
		PropadEmpProfDetails ppd2 = empProfRepository.getOne(ppd3.getEp_id());
		System.out.println("record in database"+ppd2);
		 if (ppd2.getEp_prof_mail() == ppd3.getEp_prof_mail()) {
			 PropadEmpProfDetails ppd = new PropadEmpProfDetails();
//			 ppd.setEp_id(ppd2.getEp_id());
			 ppd.setEp_prof_mail(ppd2.getEp_prof_mail());
			 if(ppd3.getEp_service_cert1()!=null) {
				 ppd.setEp_service_cert1(ppd3.getEp_service_cert1());
			 }else
			 {
				 ppd.setEp_service_cert1(ppd2.getEp_service_cert1());
			 }
			 if(ppd3.getEp_service_cert2()!=null) {
				 ppd.setEp_service_cert2(ppd3.getEp_service_cert2());
			 }else
			 {
				 ppd.setEp_service_cert2(ppd2.getEp_service_cert2());
			 }
			 if(ppd3.getEp_service_cert3()!=null) {
				 ppd.setEp_service_cert3(ppd3.getEp_service_cert3());
			 }else
			 {
				 ppd.setEp_service_cert3(ppd2.getEp_service_cert3());
			 }
			 if(ppd3.getEp_payslip1()!=null) {
				 ppd.setEp_payslip1(ppd3.getEp_payslip1());
			 }else
			 {
				 ppd.setEp_payslip2(ppd2.getEp_payslip1());
			 }

			 if(ppd3.getEp_payslip3()!=null) {
				 ppd.setEp_payslip3(ppd3.getEp_payslip3());
			 }else
			 {
				 ppd.setEp_payslip3(ppd2.getEp_payslip3());
			 }
			 
		 System.out.println("update of record needed");
		 returnrecord=ppd;
		 System.out.println("updation done successfully");
//		 returnrecord=this.empTech.save(pet);
		 
		 
		 }
		 else
		 {
			 returnrecord=ppd3;
//			 returnrecord=	 this.empTech.save(pet3);
		 }
	}
	return this.empProf.save(returnrecord);
	}
	
	@RequestMapping(value = "/update-prof-status", method = RequestMethod.POST)
	public PropadEmpProfDetails updatedocumentstatus( @RequestBody EmployeeProfDTO empProf) throws IOException, SerialException, SQLException {
		System.out.println("hiii from function");
		/////////////////updated details////////////////
		PropadEmpProfDetails ppd3 = new PropadEmpProfDetails();
		System.out.println("hiii from object");
		ppd3.setEp_id(empProf.getEp_id());
		ppd3.setEp_prof_mail(empProf.getEp_prof_mail());
		ppd3.setService1_status(empProf.getService1_status());
		ppd3.setService2_status(empProf.getService2_status());
		ppd3.setService3_status(empProf.getService3_status());
		ppd3.setPayslip1_status(empProf.getPayslip1_status());
		ppd3.setPayslip2_status(empProf.getPayslip2_status());
		ppd3.setPayslip3_status(empProf.getPayslip3_status());
		
		
		System.out.println("updarteed records"+ppd3);
		
		
		PropadEmpProfDetails returnrecord=null;
	if( ppd3.getEp_prof_mail()!=null)	{
//		PropadEmpProfDetails ppd2 = empProfRepository.getOneRow(ppd3.getEp_prof_mail());
		PropadEmpProfDetails ppd2 = empProfRepository.getOne(ppd3.getEp_id());
		System.out.println("record in database"+ppd2);
		 if (ppd2.getEp_prof_mail().equals(ppd3.getEp_prof_mail())) {
			 PropadEmpProfDetails ppd = new PropadEmpProfDetails();
			 ppd.setEp_id(ppd2.getEp_id());
			 ppd.setEp_service_cert1(ppd2.getEp_service_cert1());
			 ppd.setEp_service_cert2(ppd2.getEp_service_cert2());
			 ppd.setEp_service_cert3(ppd2.getEp_service_cert3());
			 ppd.setEp_payslip1(ppd3.getEp_payslip1());
			 ppd.setEp_payslip2(ppd3.getEp_payslip2());
			 ppd.setEp_payslip3(ppd3.getEp_payslip3());
			 ppd.setEp_prof_mail(ppd2.getEp_prof_mail());
			 ppd.setService1_status(ppd3.getService1_status());
			 ppd.setService2_status(ppd3.getService2_status());
			 ppd.setService3_status(ppd3.getService3_status());
				ppd.setPayslip1_status(ppd3.getPayslip1_status());
				ppd.setPayslip2_status(ppd3.getPayslip2_status());
				ppd.setPayslip3_status(ppd3.getPayslip3_status());
			 
			
			 
		 System.out.println("update of record needed");
		 returnrecord=ppd;
		 System.out.println("updation done successfully");
	 }
		 else
		 {
			 returnrecord=ppd3;
		 }
	}
	return this.empProf.save(returnrecord);
	}
	
	
	
	
}


