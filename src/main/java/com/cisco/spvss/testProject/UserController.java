package com.cisco.spvss.testProject;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@ModelAttribute("users")
	List<String> getUserList() {
		List<String> r = new LinkedList<String> ();
		
	    return r;
	}
	
	@RequestMapping("/")
	public ModelAndView index() {
		logger.info("Incoming index request");

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.addObject("name", "World");
		model.setViewName("index");

		return model;
	}
	
	@RequestMapping("/string")
	public String sendString() {
		logger.info("Incoming string request");

			
		return "This is a String";
	}
	

	@RequestMapping("/user/{name}")
	ModelAndView User(@PathVariable String name)  { 	

		List<String> users = new LinkedList<String>();
		logger.info("Incoming User request [" + name + "]");

		ModelAndView model = new ModelAndView();
		
		model.addObject("title", "Welcome " + name );
		model.addObject("message", "This is welcome page!");
		
		users.add("tom");
		users.add("dick");
		users.add("harry");
		
		
		model.addObject( "users", users );
		model.setViewName("user");
		
		return model;
	}
	
	
	@RequestMapping("/video")
	public ModelAndView requestVideo() {
		logger.info("Incoming video request");

		ModelAndView model = new ModelAndView();
		model.setViewName("video");

		return model;
	}
	

	
}

