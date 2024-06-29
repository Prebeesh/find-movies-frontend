package com.prebeesh1427.findmoviesfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {
	
	@RequestMapping("/")
	public String homePage() {
		return "index";
	}
	
}
