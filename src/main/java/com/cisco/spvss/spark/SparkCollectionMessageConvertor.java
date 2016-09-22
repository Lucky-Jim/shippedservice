package com.cisco.spvss.spark;

import java.io.IOException;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.cisco.spvss.spark.model.SparkCollection;
import com.cisco.spvss.spark.model.SparkObject;

public class SparkCollectionMessageConvertor extends AbstractHttpMessageConverter<SparkObject>  {

	//private final static List<MediaType> supported =  Arrays.asList( MediaType.APPLICATION_JSON  );
		
	
	@Override
	protected boolean supports(Class<?> clazz) {
		if( clazz == SparkCollection.class  )
			return true;
		
		return false;
	}

	@Override
	protected SparkObject readInternal(Class<? extends SparkObject> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void writeInternal(SparkObject t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		// TODO Auto-generated method stub
		
	}

}
