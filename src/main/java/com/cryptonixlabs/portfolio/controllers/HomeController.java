package com.cryptonixlabs.portfolio.controllers;

import java.time.Duration;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/")
	public ModelAndView home(ModelAndView model, @RequestParam String lang) {
		
		System.out.println("Language is :: "+ lang);
		model.addObject("myName", "sarita Kumari");
		model.addObject("aboutText", "Magnam dolores commodi suscipit. Necessitatibus eius consequatur ex aliquid fuga eum quidem. Sit sint consectetur velit. Quisquam quos quisquam cupiditate. Et nemo qui impedit suscipit alias ea. Quia fugiat sit in iste officiis commodi quidem hic quas.");
		model.addObject("birthday", "may 1 1995S");
		model.addObject("website", "www.example.com");
		model.addObject("jobTitle", "UI/UX Designer & Web Developer.");
		model.addObject("jobSummary", "I am a very creative UI/UX designer, with some serious knowledge of Java based backend");
		model.addObject("email", "cryptonixlabs.com");
		model.addObject("age", calculateAge(LocalDate.of(1995, 5, 15)));
		
		model.setViewName("index");
		return model;
	}
	
	@GetMapping("/sarita")
	public String sarita() {
		return "index";
	}
	/**
	 * It will calculate age from given dob
	 * @param dob
	 * @return age
	 */
	private int calculateAge(LocalDate dob) {
		// 
		//
		return 0;
	}
}
