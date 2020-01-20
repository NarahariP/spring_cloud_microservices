package com.hari.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurence-service")
public class ServiceController {

	@GetMapping("/")
	public String welcome() {
		return "Welcome";
	}

	@GetMapping("/getAllPlans")
	public List<String> getAllPlans() {
		return Stream.of("Gold", "Car", "House", "Marriage", "Education").collect(Collectors.toList());
	}
}
