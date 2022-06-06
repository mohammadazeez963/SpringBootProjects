package com.zensar.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class HelloController {
	
		@GetMapping(value = "/greet/{myName}")
		public String hello(@PathVariable(name = "myName") String name) {
			return "Hello "+name+" Welcome to REST services";
		}
}
