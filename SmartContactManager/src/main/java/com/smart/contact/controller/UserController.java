package com.smart.contact.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.contact.helper.Message;
import com.smart.contact.model.User;
import com.smart.contact.repo.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository reposit;

	@RequestMapping("/")
	public String home(Model model) {

		model.addAttribute("title", "Home - Smart Contact Manager");
		return "home";
	}

	@RequestMapping("/about")
	public String about(Model model) {

		model.addAttribute("title", "Home - Smart Contact Manager");
		return "about";
	}

	@RequestMapping("/signup")
	public String signup(Model model) {

		model.addAttribute("title", "Register Home - Smart Contact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/do_register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult results,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agrement, Model model, HttpSession httpSession) {

		try {
			if (!agrement) {
				System.out.println("not agrement and term and conditons");
				throw new Exception("not agrement and term and conditons");
			}
			
			if(results.hasErrors()) {
				System.out.println("Giving result ::"+results.toString());
				model.addAttribute("user",user);
				return "signup";
			}
			
			
			user.setRole("sfdsafaf");
			user.setEnabled(true);
			user.setImageUrl("Default image");
			
			System.out.println("Agreemnent" + agrement);
			System.out.println("User ka " + user);
			
			User save = reposit.save(user);
			
			
			model.addAttribute("user",new User());
			httpSession.setAttribute("message", new Message("Successfully registered!!","Alert-success"));
			return "signup";
		
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
			httpSession.setAttribute("message", new Message("Something went wrong!!"+e.getMessage(),"Alert-danger"));
			return "signup";
		}
	}

}
