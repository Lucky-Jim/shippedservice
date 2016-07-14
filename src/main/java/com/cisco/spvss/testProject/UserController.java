package com.cisco.spvss.testProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@RequestMapping("/")
	public ModelAndView index() {
		logger.info("Incoming index request");

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("welcome");

		return model;
	}

	@RequestMapping("/hello/{name}")
	View hello(@PathVariable String name)  {

		logger.info("Incoming request : " + name );
		return new TestApplicationView( );
	}
	
	
}

