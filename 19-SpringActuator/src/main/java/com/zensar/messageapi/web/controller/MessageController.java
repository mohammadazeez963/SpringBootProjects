package com.zensar.messageapi.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zensar.messageapi.entity.Message;

@Controller
public class MessageController {
	private List<Message> messages;
	public MessageController(){
		this.messages = new ArrayList<Message>();
		Message m1 = new Message();
		m1.setId(1);
		m1.setMessage("Hello");
		this.messages.add(m1);
	}
	@GetMapping("/message")
	public String showAllMessages(Model m) {
		m.addAttribute("allMessages", this.messages);
		return "messages";
	}
	
	@GetMapping("/welcome")
	public String web(Model m) {
		System.out.println("In Home()");
		m.addAttribute("name", "Zensar India");
		return "index"; // Here we are returning the name of html page
									// This template must be present in src/main/resources/templates folder
		
	}

}
