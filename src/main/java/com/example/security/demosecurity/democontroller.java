package com.example.security.demosecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class democontroller {

	
	@GetMapping("/")
	public String demo(HttpServletRequest req) {
		return "hello "+req.getSession().getId();
	}
	
	
}
