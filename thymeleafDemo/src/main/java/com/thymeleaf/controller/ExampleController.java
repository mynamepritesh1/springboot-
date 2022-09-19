package com.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {
	
	//creating handler for adding css,javascript and image
	@GetMapping("/example")
	public String example() {
		
		
		return "example";
		
	}

}
