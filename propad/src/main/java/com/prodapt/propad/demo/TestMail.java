package com.prodapt.propad.demo;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class TestMail {

	
	@Autowired
	private MailSenderService mailSenderService;
	
	@GetMapping("test")
	public String getTest() {
		return "hello";
	}
	
	
	 
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	    public String sendMail(@RequestParam("user_email") String user_email, @RequestParam("user_password") String user_password) {
		EmailProperties emailProperties=new EmailProperties();
		
		emailProperties.setFrom("banu.b@prodapt.com");
		String s=user_email;
		String pwd=user_password;
		System.out.println(s);
		emailProperties.setTo(s);
		emailProperties.setBody("hi,"
				+ "your username is "+ s
				+" your password is" +pwd );
		emailProperties.setSubject("initiation process");
		try {
			mailSenderService.sendEmployeeMessage(emailProperties);
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			
		}
	        return "Mail Sent Success!";
	    }

}
