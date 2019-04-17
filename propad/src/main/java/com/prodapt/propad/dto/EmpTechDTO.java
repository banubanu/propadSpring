package com.prodapt.propad.dto;

import java.sql.Blob;
import org.springframework.web.multipart.MultipartFile;

public class EmpTechDTO {

	private int et_id;
	private int et_emp_id;
	private Blob et_tech_cert1;
	private String et_tech_cert1_text;
	private Blob et_tech_cert2;
	private String et_tech_cert2_text;
	private byte[] et_tech_cert3;
	private String et_tech_cert3_text;
	private Blob et_tech_cert4;
	private String et_tech_cert4_text;
	private Blob et_tech_cert5;
	private String et_tech_cert5_text;
	private String et_tech_comments;
	
	
	
	public String getEt_tech_comments() {
		return et_tech_comments;
	}
	public void setEt_tech_comments(String et_tech_comments) {
		this.et_tech_comments = et_tech_comments;
	}
	public int getEt_id() {
		return et_id;
	}
	public int setEt_id(int et_id) {
		return this.et_id = et_id;
	}
	public int getEt_emp_id() {
		return et_emp_id;
	}
	public int setEt_emp_id(int et_emp_id) {
		return this.et_emp_id = et_emp_id;
	}
	public Blob getEt_tech_cert1() {
		return et_tech_cert1;
	}
	public Blob setEt_tech_cert1(Blob et_tech_cert1) {
		return this.et_tech_cert1 = et_tech_cert1;
	}
	public String getEt_tech_cert1_text() {
		return et_tech_cert1_text;
	}
	public String setEt_tech_cert1_text(String et_tech_cert1_text) {
		return this.et_tech_cert1_text = et_tech_cert1_text;
	}
	public Blob getEt_tech_cert2() {
		return et_tech_cert2;
	}
	public Blob setEt_tech_cert2(Blob et_tech_cert2) {
		return this.et_tech_cert2 = et_tech_cert2;
	}
	public String getEt_tech_cert2_text() {
		return et_tech_cert2_text;
	}
	public String setEt_tech_cert2_text(String et_tech_cert2_text) {
		return this.et_tech_cert2_text = et_tech_cert2_text;
	}
	public byte[] getEt_tech_cert3() {
		return et_tech_cert3;
	}
	public byte[] setEt_tech_cert3(byte[] et_tech_cert3) {
		return this.et_tech_cert3 = et_tech_cert3;
	}
	public String getEt_tech_cert3_text() {
		return et_tech_cert3_text;
	}
	public String setEt_tech_cert3_text(String et_tech_cert3_text) {
		return this.et_tech_cert3_text = et_tech_cert3_text;
	}
	public Blob getEt_tech_cert4() {
		return et_tech_cert4;
	}
	public Blob setEt_tech_cert4(Blob et_tech_cert4) {
		return this.et_tech_cert4 = et_tech_cert4;
	}
	
	public String getEt_tech_cert4_text() {
		return et_tech_cert4_text;
	}
	public String setEt_tech_cert4_text(String et_tech_cert4_text) {
		return this.et_tech_cert4_text = et_tech_cert4_text;
	}
	public Blob getEt_tech_cert5() {
		return et_tech_cert5;
	}
	public Blob setEt_tech_cert5(Blob et_tech_cert5) {
		return this.et_tech_cert5 = et_tech_cert5;
	}
	public String getEt_tech_cert5_text() {
		return et_tech_cert5_text;
	}
	public String setEt_tech_cert5_text(String et_tech_cert5_text) {
		return this.et_tech_cert5_text = et_tech_cert5_text;
	}
	
}
