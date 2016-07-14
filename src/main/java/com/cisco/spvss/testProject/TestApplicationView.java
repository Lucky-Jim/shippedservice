package com.cisco.spvss.testProject;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

public class TestApplicationView extends AbstractUrlBasedView {

	private static final Logger logger = LoggerFactory.getLogger(TestApplicationView.class);

	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info( "Somehow I got called  ");

		
		
	}

}
