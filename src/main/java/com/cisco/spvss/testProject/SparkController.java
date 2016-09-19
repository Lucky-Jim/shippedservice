package com.cisco.spvss.testProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SparkController {

	private static final Logger tom_logger = LoggerFactory.getLogger(SparkController.class);
	
	@RequestMapping("/spark/{name}")
	public String sparkHook(@PathVariable String name) {
		tom_logger.info("Incoming Sparks request");

			
		return "This is a String";
	}
}
