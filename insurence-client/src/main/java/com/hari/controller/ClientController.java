package com.hari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${insurence.provide.url}")
	private String url;

	@GetMapping("/getPlans")
	public List<String> getPlans() {
		return restTemplate.getForObject(url, List.class);
	}

	@GetMapping("/")
	public String welcome() {
		return "Welcome";
	}
}
