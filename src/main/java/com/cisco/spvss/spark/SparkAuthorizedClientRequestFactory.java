package com.cisco.spvss.spark;

import java.io.IOException;
import java.net.URI;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class SparkAuthorizedClientRequestFactory extends  HttpComponentsClientHttpRequestFactory {

	private String token;
	
	public SparkAuthorizedClientRequestFactory(String token) {
		super();
        this.token = token;
	}

	@Override
	public ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod) throws IOException {
		ClientHttpRequest request = super.createRequest(uri, httpMethod);
		request.getHeaders().add( "Authorization", "Bearer " + token );
		return request;
	}


}
