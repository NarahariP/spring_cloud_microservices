package com.hari.controller;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hari.bean.ExchangeBean;
import com.hari.repository.ExchangeRepository;

@RestController
public class CurrencyExchangeController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Environment environment;

	@Autowired
	private ExchangeRepository exchangeRepository;

	Function<ExchangeBean, ExchangeBean> exchangeBeanFunction = exchangeBean -> {
		exchangeBean.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		logger.info("exchangeBean : " + exchangeBean);
		return exchangeBean;
	};

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeBean getExchangeValue(@PathVariable String from, @PathVariable String to) {
		return exchangeBeanFunction
				.apply(exchangeRepository.findByFromIgnoreCaseAndToIgnoreCase(from, to).orElse(new ExchangeBean()));
	}

}
