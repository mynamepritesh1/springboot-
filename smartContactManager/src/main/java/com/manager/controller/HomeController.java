package com.manager.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manager.dao.UserRepository;
import com.manager.entities.User;
import com.manager.helper.Message;

@Controller
public class HomeController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	@Autowired
	private UserRepository userRepository;
	
	//handler of login 
	@GetMapping("/signin")
	public String CustomLogin(Model m) {
		m.addAttribute("title", "Login Page");
		
		
		return "login";
		
	}
//	@GetMapping("/login-fail")
//	public String LoginFail(Model m) {
//		m.addAttribute("title", "Error-page");
//		return "error";
//	}
//


//	handler for home page
	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("title", "Home-Smart Contact Manager");
		return "home";

	}

//handler for about page
	@GetMapping("/about")
	public String about(Model m) {
		m.addAttribute("title", "about-Smart Contact Manager");
		return "about";

	}

	// signup handler
	@GetMapping("/signup")
	public String signup(Model m) {
		m.addAttribute("title", "signup-Smart Contact Manager");
		m.addAttribute("user", new User());
		return "signup";

	}

	// handler for registering user
	// @requestParam we have used for we dnt create field for terms and condition
	@PostMapping("/do_register")
	public String registeringUser(@Valid @ModelAttribute("user") User user,BindingResult res,
			@RequestParam(value = "agriment", defaultValue = "false") 
	boolean agriment, Model m, HttpSession session) {
		try {
			if (!agriment) {
				System.out.println("you have not agreed terms and condition");
				throw new Exception("you have not agreed terms and condition");

			}
			if(res.hasErrors()) {
				System.out.println("ERROR " + res.toString());
				m.addAttribute("user", user);
				return "signup";
			}

			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageUrl("default.png");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			

			System.out.println("agreement" + agriment);
			System.out.println("User" + user);
			m.addAttribute("user", user);

			// for connection with database
			User result = this.userRepository.save(user);
			m.addAttribute("user", new User());
			session.setAttribute("message", new Message("Sucessfully Registered..! ", "alert-success"));
			return "signup";

		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("user", user);
			session.setAttribute("message", new Message(("Something Went Wrong !! " + e.getMessage()), "alert-danger"));
			return "signup";
		}
		
		
	}

}
