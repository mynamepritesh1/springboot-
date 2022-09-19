package com.manager.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manager.dao.UserRepository;
import com.manager.entities.Contact;
import com.manager.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
//method for adding common data to response
	
	@ModelAttribute
	public void addCommonData(Model m, Principal principal) {
		String userName = principal.getName();
		System.out.println("USERNAME" + userName);

		// get the user using user name(email)

		User user = this.userRepository.getUserByUserName(userName);
		System.out.println("USER " + user);

		m.addAttribute("user", user);

	}

	// handler for dash board here we are getting the user name
	@GetMapping("/index")
	public String dashboard(Model m, Principal principal) {
		m.addAttribute("title", "User Dashboard");
		

		return "normal/user_dashboard";

	}

	// handler for open add contact

	@GetMapping("/add_contact")
	public String openAddContactForm(Model m) {
		m.addAttribute("title", "Add Contact");
		
		m.addAttribute("contact", new Contact());

		return "normal/add_contact_form";

	}
	//handler for processing at contact form
	
	@PostMapping("/process-contact")
	public String processContact(@ModelAttribute Contact contact, Principal principal) {
		//adding data in data base 
		String name =principal.getName();
		
		User user= this.userRepository.getUserByUserName(name);
		contact.setUser( user);
		
		user.getContact().add(contact);
		
		this.userRepository.save(user);
		System.out.println("Added to data base");
		
		System.out.println("DATA "+  contact);
		return "normal/add_contact_form";
		
		
	}

}
