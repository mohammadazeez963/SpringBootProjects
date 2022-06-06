package com.zensar.displayservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.displayservice.feign.client.MessageFeignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class DisplayServiceImpl {
	@Autowired
	private MessageFeignClient feignClient;
	
	@CircuitBreaker(name = "messageservice",fallbackMethod = "handleFailure")
	
	public String printMessage() {
		return this.feignClient.callGenerateMessage();
	}

	public String handleFailure(Throwable t) {
		return "This is the default message because Microservice is not running ... please try again ...";
	}
}
