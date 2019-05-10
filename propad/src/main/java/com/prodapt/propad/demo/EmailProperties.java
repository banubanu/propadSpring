package com.prodapt.propad.demo;

import java.io.Serializable;

public class EmailProperties implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 95601L;
	
	private String from;
	private String to;
	private String subject;
	private String body;
	private String cc;
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	

}
