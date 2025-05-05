package com.prebeesh1427.findmoviesfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

	// This mapping will only forward requests that do not contain a dot (.)
	@RequestMapping(value = {"/{path:[^\\.]*}", "/home", "/about", "/"})
	public String forward() {
		return "forward:/index.html";
	}
}