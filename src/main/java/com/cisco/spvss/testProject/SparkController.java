package com.cisco.spvss.testProject;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SparkController {

	private static final Logger tom_logger = LoggerFactory.getLogger(SparkController.class);
	
	private static LinkedList<SparkMessage> messages = new LinkedList<SparkMessage>();
	
	
	@RequestMapping("/spark/test")
	public String sparkHook( @RequestBody SparkMessage message) {
		tom_logger.info("Incoming Sparks request");

		messages.add( message );
			
		return "This is a String";
	}
	
	@RequestMapping("/spark/messages")
	public @ResponseBody ResponseEntity<List<SparkMessage>> getMessages( ) {
		tom_logger.info("Incoming List request");

			
		 return new ResponseEntity<List<SparkMessage>> (messages, HttpStatus.OK); // XXX
	}
	
	
}
