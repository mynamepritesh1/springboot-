package com.thymeleaf.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/about")
	public String about(Model m) {

		System.out.println("inside the about handler");

		// putting data
		m.addAttribute("name", "pritesh Ingale");
		m.addAttribute("currentDate", new Date().toLocaleString());
		return "about";

	}
	// this is for handling iteration

	@GetMapping("/example-loop")
	public String iterateHandler(Model m) {
		// send

		// create a list,set collection
		List<String> names = List.of("PRITESH", "priyanka", "karan", "akkaa");
		m.addAttribute("names", names);

		return "iterate";
	}

	// handler for conditional statement in thymeleaf
	@GetMapping("/condition")
	public String conditionalHandler(Model m) {
		m.addAttribute("isActive", true);
		m.addAttribute("gender", "F");
		List<Integer> list = List.of(0);
		m.addAttribute("mylist", list);

		return "condition";
	}

	// handler for including fragment
	@GetMapping("/service")
	public String servicesHandler(Model m) {
		// processing logic,.... how to dynamic value pass through
		// include,replace,insert
		m.addAttribute("title", "title for footer page");
		m.addAttribute("subtitle" , new Date().toLocaleString());
		return "service";
	}
	
	//newabout handler
	@GetMapping("/newAbout")
	public String newAbout() {
		
		return "aboutnew";
		
		
	}
	//server side validatio handler

}
