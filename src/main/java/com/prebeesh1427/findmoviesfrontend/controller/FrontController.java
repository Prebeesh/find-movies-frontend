package com.prebeesh1427.findmoviesfrontend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

	Logger logger = LoggerFactory.getLogger(FrontController.class);
	
	@RequestMapping("/")
	public String homePage() {
		logger.info("Received a request in home");
		return "index";
	}
	
}
