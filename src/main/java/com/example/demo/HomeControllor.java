package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControllor {
	@GetMapping("/")
	public String Hello() {
		return "Spring Server";
	}
}
