package com.validations.cont;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.validations.model.Form;

@Controller
public class MyController implements WebMvcConfigurer{
	
	
	
	public void addviewController(ViewControllerRegistry controllerRegistry) {
		controllerRegistry.addViewController("/results").setViewName("results");
		
		
	}
	
    @GetMapping("/")
    public String showForm(Form form) {
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid Form form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    }
	
	
	

}

