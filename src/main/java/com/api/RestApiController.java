package com.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestApiController {
	
	@RequestMapping("/index")
	public String showInfo(Model model) {
		return "index";
	}
	
	
}
