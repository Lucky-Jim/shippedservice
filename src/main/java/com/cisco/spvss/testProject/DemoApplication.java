package com.cisco.spvss.testProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


/***
 * 
 * This is my class that represents the embedded Tomcat Server
 * 
 * 
 * @author tburnley
 *
 */

@Configuration
@EnableScheduling
@EnableAutoConfiguration
@ComponentScan
public class DemoApplication extends SpringApplication{
	static ConfigurableApplicationContext ctx;
	private static final Logger tom_logger = LoggerFactory.getLogger(DemoApplication.class);
	
	@Override
	protected void load(ApplicationContext context, Object[] sources) {
        tom_logger.info("Application Loading");
        super.load(context, sources);
	}
	
	public static void main(String[] args) {
        ctx = SpringApplication.run(DemoApplication.class, args);
        tom_logger.info("Application Started");
    }
    
	
}


