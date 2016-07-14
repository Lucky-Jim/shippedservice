package com.cisco.spvss.testProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.context.support.ResourceBundleMessageSource;

import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Configuration
@ComponentScan
@SpringBootApplication
public class DemoApplication {

	private static final Logger tom_logger = LoggerFactory.getLogger(DemoApplication.class);
	static ConfigurableApplicationContext ctx;
	
	public static void main(String[] args) {
        ctx = SpringApplication.run(DemoApplication.class, args);
        
        tom_logger.info("Application Started");
        
        
    }
    
	
    
    //
    //			Stolen :https://punitusingh.wordpress.com/category/spring-framework/spring-mvc/
    //
    @Bean
    public ViewResolver setupUrlBasedViewResolver(){
        UrlBasedViewResolver urlBasedViewResolver=new UrlBasedViewResolver();
        urlBasedViewResolver.setPrefix("/jsp/");
        urlBasedViewResolver.setSuffix(".jsp");
        urlBasedViewResolver.setViewClass(JstlView.class);
        
        
        tom_logger.info("Inserting URL Based View Resolver");
        return urlBasedViewResolver;
    }
    
    
//    @Bean
//   public ViewResolver setupResourceBasedViewResolver(){
//        ResourceBundleViewResolver resourceBundleViewResolver=new ResourceBundleViewResolver();
//       
//        
//        tom_logger.info("Inserting Resource Based View Resolver");
//        return resourceBundleViewResolver;
//    }
    
    
    @Bean 
    ResourceBundleMessageSource setupResourceBundleMessageSource(){
    	ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
    	resourceBundleMessageSource.setBasename("application");
    	
    	resourceBundleMessageSource.setFallbackToSystemLocale(true);
    	
    	tom_logger.info("Inserting Resource Bundle Message Source");
    	return resourceBundleMessageSource;
    }
}


