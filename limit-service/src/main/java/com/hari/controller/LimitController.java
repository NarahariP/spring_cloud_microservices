package com.hari.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hari.bean.LimitConfiguration;
import com.hari.config.LimitConfigConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RefreshScope
public class LimitController {

	@Autowired
	private LimitConfigConfiguration limitConfigConfiguration;

	@GetMapping("/limits")
	public LimitConfiguration getLimitsFromConfigurations() {
		return new LimitConfiguration(limitConfigConfiguration.getMaximum(), limitConfigConfiguration.getMinimum());
	}

	@GetMapping("/fault-tolerance-limits")
	@HystrixCommand(fallbackMethod = "fallbackLimitMethod")
	public LimitConfiguration retriveLimitConfiguration() {
		throw new RuntimeException("Error occured ");
	}

	public LimitConfiguration fallbackLimitMethod() {
		return new LimitConfiguration(36, 366);
	}

}
