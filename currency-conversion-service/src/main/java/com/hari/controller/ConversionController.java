package com.hari.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hari.bean.ConversionBean;
import com.hari.feign.proxy.CurrencyExchangeServiceProxy;

@RestController
public class ConversionController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

	BiFunction<ConversionBean, BigDecimal, ConversionBean> conversionBeanBiFunction = (conversionBean, quentity) -> {
		conversionBean.setTotalCalculatedAmount(
				quentity.multiply(conversionBean.getConversionFactor().orElse(BigDecimal.ZERO)));
		conversionBean.setPort(conversionBean.getPort());
		logger.info("conversionBean : " + conversionBean);
		return conversionBean;
	};

	@GetMapping("/currency-converter/from/{from}/to/{to}/quentity/{quentity}")
	public ConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quentity) {
		final Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		final ConversionBean response = new RestTemplate()
				.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", ConversionBean.class,
						uriVariables)
				.getBody();
		return conversionBeanBiFunction.apply(response, quentity);

	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quentity/{quentity}")
	public ConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quentity) {
		return conversionBeanBiFunction.apply(currencyExchangeServiceProxy.getExchangeValue(from, to), quentity);
	}
}
