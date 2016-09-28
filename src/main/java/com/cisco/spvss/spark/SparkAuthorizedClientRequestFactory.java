package com.cisco.spvss.spark;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class SparkAuthorizedClientRequestFactory extends  HttpComponentsClientHttpRequestFactory {

	private String token;
	
	private final static List<MediaType> acceptable =  Arrays.asList(MediaType.APPLICATION_JSON);
	
	public SparkAuthorizedClientRequestFactory(String token) {
		super();
        this.token = token;
	}

	@Override
	public ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod) throws IOException {
		
		ClientHttpRequest request = super.createRequest(uri, httpMethod);
		//request.getHeaders().setContentType(MediaType.APPLICATION_JSON);
		
		request.getHeaders().add( "Content-type", "application/json; charset=utf-8");
		request.getHeaders().add( "Authorization", "Bearer " + token );

		
		
		//request.getHeaders().setAccept(acceptable);
		return request;
	}


}
