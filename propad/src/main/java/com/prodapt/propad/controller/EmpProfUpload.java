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

import com.prodapt.propad.dto.EmployeeProfDTO;
import com.prodapt.propad.model.PropadEmpProfDetails;
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
    public ResponseEntity<Status> getsave(@RequestParam Integer ep_emp_id){
           Status status=new Status();
           List<PropadEmpProfDetails> list=empProfRepository.findByEp_emp_id(ep_emp_id);
          // List<RtSavedJobDetails> list = savedRepository.findBySjEmployeeCodeAndRtJobDetails_JdPositionCode(sjEmployeeCode, jdPositionCode);
             if(!list.isEmpty()&& list.size()>0) 
             { 
                    status.setStatusCode(200);
                    status.setPropadEmpProfDetails(list.get(0));
             }
           return new ResponseEntity<Status>(status, HttpStatus.OK);
    }
	
	
	@RequestMapping(value = "/upload-document", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public PropadEmpProfDetails uploaddocumentModel( @RequestPart(required = false) Map<String, String> json, EmployeeProfDTO empProf, @RequestParam("file") MultipartFile file, @RequestParam(required = false) MultipartFile file1,@RequestParam(required = false) MultipartFile file2,@RequestParam(required = false) MultipartFile file3,@RequestParam(required = false) MultipartFile file4, @RequestParam(required = false) MultipartFile file5) throws IOException, SerialException, SQLException {
		System.out.println("test"+file.getOriginalFilename());
		System.out.println(file.getBytes());
//		System.out.println(emptech.getEt_tech_cert1());
		
		PropadEmpProfDetails ppd = new PropadEmpProfDetails();
//  pet.setEt_tech_cert1(((EmpTechDTO) file).getEt_tech_cert1());
//	pet.setEt_emp_id(et_emp_id);
		
		ppd.setEp_emp_id(empProf.getEp_emp_id());
		ppd.setEp_service_cert1(file.getBytes());
		ppd.setEp_service_cert1_text(empProf.getEp_service_cert1_text());
		ppd.setEp_service_cert2(file1.getBytes());
		ppd.setEp_service_cert2_text(empProf.getEp_service_cert2_text());
		ppd.setEp_service_cert3(file2.getBytes());
		ppd.setEp_service_cert3_text(empProf.getEp_service_cert3_text());
		ppd.setEp_payslip1(file3.getBytes());
		ppd.setEp_payslip1_text(empProf.getEp_payslip1_text());
		ppd.setEp_payslip2(file4.getBytes());
		ppd.setEp_payslip2_text(empProf.getEp_payslip2_text());
		ppd.setEp_payslip3(file5.getBytes());
		ppd.setEp_payslip3_text(empProf.getEp_payslip3_text());
		return this.empProf.save(ppd) ;
	}

}


