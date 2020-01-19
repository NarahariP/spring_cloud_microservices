package com.hari.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ExchangeBean {

	@Id
	@GeneratedValue
	private int id;
	@Column(name = "currency_from")
	private String from;
	@Column(name = "currecy_to")
	private String to;
	private BigDecimal conversionFactor;
	private int port;

	public ExchangeBean() {
		super();
	}

	public ExchangeBean(int id, String from, String to, BigDecimal conversionFactor) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionFactor = conversionFactor;
	}

	public ExchangeBean(String from, String to, BigDecimal conversionFactor) {
		super();
		this.from = from;
		this.to = to;
		this.conversionFactor = conversionFactor;
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

	public BigDecimal getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(BigDecimal conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
