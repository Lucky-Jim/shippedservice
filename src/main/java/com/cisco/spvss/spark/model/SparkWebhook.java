package com.cisco.spvss.spark.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public class SparkWebhook extends SparkObject {

	private String name;
	private String targetUrl;
	private String resource;
	private String event;
	private String filter;
	private String secret;
	
	public String getName() {
		return name;
	}
	
	public SparkWebhook setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public String getTargetUrl() {
		return targetUrl;
	}
	
	public SparkWebhook setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
		return this;
	}

	public String getResource() {
		return resource;
	}
	
	public SparkWebhook setResource(String resource) {
		this.resource = resource;
		return this;
	}
	
	public String getEvent() {
		return event;
	}
	
	public SparkWebhook setEvent(String event) {
		this.event = event;
		return this;
	}
	
	
	public String getFilter() {
		return filter;
	}
	public SparkWebhook setFilter(String filter) {
		this.filter = filter;
		return this;
	}
	
	
	public String getSecret() {
		return secret;
	}
	public SparkWebhook setSecret(String secret) {
		this.secret = secret;
		return this;
	}
	
	
}


