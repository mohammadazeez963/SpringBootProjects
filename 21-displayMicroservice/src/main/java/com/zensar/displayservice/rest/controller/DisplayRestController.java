package com.zensar.displayservice.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.displayservice.feign.client.MessageFeignClient;
import com.zensar.displayservice.service.impl.DisplayServiceImpl;

@RestController
public class DisplayRestController {
	
	@Autowired
	private DisplayServiceImpl service;
	
		@Value("${company}") // This value is fetched from get repository using config server
		private String company;
		
		@GetMapping(value = "/api/display")
		public String printMassage() {
			
			
			return this.service.printMessage()+" from "+company;
		}
}