package com.prodapt.propad.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "propad_emp_per_details")
public class PropadEmpPerDetails implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eper_id;
	
	private int ep_per_emp_id;
	private byte[] ep_per_addressproof;
	private String ep_per_addressproof_text;
	private byte[] ep_per_pp;
	private String ep_per_pp_text;
	private byte[] ep_per_pan;
	private String ep_per_pan_text;
	private byte[] ep_per_aadhar;
	private String ep_per_aadhar_text;
	
	
	public int getEper_id() {
		return eper_id;
	}
	public void setEper_id(int eper_id) {
		this.eper_id = eper_id;
	}
	public int getEp_per_emp_id() {
		return ep_per_emp_id;
	}
	public void setEp_per_emp_id(int ep_per_emp_id) {
		this.ep_per_emp_id = ep_per_emp_id;
	}
	public byte[] getEp_per_addressproof() {
		return ep_per_addressproof;
	}
	public void setEp_per_addressproof(byte[] bs) {
		this.ep_per_addressproof = bs;
	}
	public String getEp_per_addressproof_text() {
		return ep_per_addressproof_text;
	}
	public void setEp_per_addressproof_text(String ep_per_addressproof_text) {
		this.ep_per_addressproof_text = ep_per_addressproof_text;
	}
	public byte[] getEp_per_pp() {
		return ep_per_pp;
	}
	public void setEp_per_pp(byte[] bs) {
		System.out.println("in model");
		this.ep_per_pp = bs;
	}
	public String getEp_per_pp_text() {
		return ep_per_pp_text;
	}
	public void setEp_per_pp_text(String ep_per_pp_text) {
		this.ep_per_pp_text = ep_per_pp_text;
	}
	public byte[] getEp_per_pan() {
		return ep_per_pan;
	}
	public void setEp_per_pan(byte[] bs) {
		this.ep_per_pan = bs;
	}
	public String getEp_per_pan_text() {
		return ep_per_pan_text;
	}
	public void setEp_per_pan_text(String ep_per_pan_text) {
		this.ep_per_pan_text = ep_per_pan_text;
	}
	public byte[] getEp_per_aadhar() {
		return ep_per_aadhar;
	}
	public void setEp_per_aadhar(byte[] bs) {
		this.ep_per_aadhar = bs;
	}
	public String getEp_per_aadhar_text() {
		return ep_per_aadhar_text;
	}
	public void setEp_per_aadhar_text(String ep_per_aadhar_text) {
		this.ep_per_aadhar_text = ep_per_aadhar_text;
	}
	@Override
	public String toString() {
		return "PropadEmpPerDetails [eper_id=" + eper_id + ", ep_per_emp_id=" + ep_per_emp_id + ", ep_per_addressproof="
				+ Arrays.toString(ep_per_addressproof) + ", ep_per_addressproof_text=" + ep_per_addressproof_text
				+ ", ep_per_pp=" + Arrays.toString(ep_per_pp) + ", ep_per_pp_text=" + ep_per_pp_text + ", ep_per_pan="
				+ Arrays.toString(ep_per_pan) + ", ep_per_pan_text=" + ep_per_pan_text + ", ep_per_aadhar="
				+ Arrays.toString(ep_per_aadhar) + ", ep_per_aadhar_text=" + ep_per_aadhar_text + "]";
	}
	
	
	
	
	

}
