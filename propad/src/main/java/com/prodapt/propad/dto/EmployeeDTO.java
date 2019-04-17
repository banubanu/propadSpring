package com.prodapt.propad.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class EmployeeDTO {
	
	private int ie_id;
	private int ie_emp_id;
	private String ie_emp_name;
	private String ie_emp_email;
	private Date ie_emp_doj;
	private String ie_int1;
	private String ie_int2;
	private String ie_status;
	private Date ie_emp_date;
	
	public Date getIe_date() {
		return ie_emp_date;
	}
	public Date setIe_date() {
		return this.ie_emp_date = new Date();
	}
	
	public int getIe_id() {
		return ie_id;
	}
	public int setIe_id(int ie_id) {
		return this.ie_id = ie_id;
	}
	public int getIe_emp_id() {
		return ie_emp_id;
	}
	public int setIe_emp_id(int ie_emp_id) {
		return this.ie_emp_id = ie_emp_id;
	}
	public String getIe_emp_name() {
		return ie_emp_name;
	}
	public String setIe_emp_name(String ie_emp_name) {
		return this.ie_emp_name = ie_emp_name;
		
	}
	public String getIe_emp_email() {
		return ie_emp_email;
	}
	public String setIe_emp_email(String ie_emp_email) {
		return this.ie_emp_email = ie_emp_email;
	}
	public Date getIe_emp_doj() {
		return ie_emp_doj;
	}
	public Date  setIe_emp_doj() {
		return this.ie_emp_doj = new Date() ;
	}
	public String getIe_int1() {
		return ie_int1;
	}
	public String setIe_int1(String ie_int1) {
		return this.ie_int1 = ie_int1;
	}
	public String getIe_int2() {
		return ie_int2;
	}
	public String setIe_int2(String ie_int2) {
		return this.ie_int2 = ie_int2;
	}
	public String getIe_status() {
		return ie_status;
	}
	public String  setIe_status(String ie_status) {
		return this.ie_status = ie_status;
	}

}
