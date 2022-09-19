package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.entities.EmailRequest;
import com.email.services.EmailService;

@RestController
public class Econtroller {
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/welcome")
	public String welcome() {
		
		return "Hello this is my email api";
	}
	//api to send email
	
	@PostMapping("/sendemail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
		System.out.println(request);
		
		boolean result =this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
		if (result) {
			return ResponseEntity.ok("Email sent successfully.....");
			
		} else {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Email not sent...");

		}
		
		
		
	}

}
