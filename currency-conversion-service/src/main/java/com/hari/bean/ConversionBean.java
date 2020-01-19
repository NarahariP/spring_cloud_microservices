package com.hari.bean;

import java.math.BigDecimal;
import java.util.Optional;

public class ConversionBean {
	private int id;
	private String from;
	private String to;
	private Optional<BigDecimal> conversionFactor;
	private BigDecimal quentity;
	private BigDecimal totalCalculatedAmount;
	private int port;

	public ConversionBean() {
		super();
	}

	public ConversionBean(String from, String to, Optional<BigDecimal> conversionFactor, BigDecimal quentity,
			BigDecimal totalCalculatedAmount, int port) {
		super();
		this.from = from;
		this.to = to;
		this.conversionFactor = conversionFactor;
		this.quentity = quentity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.port = port;
	}

	public ConversionBean(int id, String from, String to, Optional<BigDecimal> conversionFactor, BigDecimal quentity,
			BigDecimal totalCalculatedAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionFactor = conversionFactor;
		this.quentity = quentity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.port = port;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Optional<BigDecimal> getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(Optional<BigDecimal> conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public BigDecimal getQuentity() {
		return quentity;
	}

	public void setQuentity(BigDecimal quentity) {
		this.quentity = quentity;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
