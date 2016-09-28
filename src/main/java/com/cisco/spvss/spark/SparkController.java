package com.cisco.spvss.spark;

import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cisco.spvss.spark.model.SparkMessage;
import com.cisco.spvss.spark.model.SparkMessageData;
import com.cisco.spvss.spark.model.SparkRoom;
import com.cisco.spvss.spark.model.SparkRoomCollection;
import com.cisco.spvss.spark.model.SparkWebHookCollection;
import com.cisco.spvss.spark.model.SparkWebhook;

@RestController
public class SparkController implements InitializingBean {

	private static final Logger tom_logger = LoggerFactory.getLogger(SparkController.class);
	final static String HOOK_NAME = "TomBot";
	final static String accessToken = "MmZhNDc2MjMtNWY5Zi00MDU3LWI0MjUtOGJjYmM3ODBhYTYyYjNlYWMwZjctZWEx";
    
	
	final static String TomBurnley = "Y2lzY29zcGFyazovL3VzL1BFT1BMRS9jNTQyN2U2My1iMWUyLTRhOTItYThiYi0wMDQ3MWM4ZTZlYTI";
	
	/*
	 * OK - so, my collections of things
	 */
	private LinkedList<SparkMessage> messages = new LinkedList<SparkMessage>();
	private LinkedList<SparkRoom> rooms = new LinkedList<SparkRoom>();
	private LinkedList<SparkWebhook> webhooks = new LinkedList<SparkWebhook>();
	 
	/*
	 * the webhoox that I'm using..... registered on init
	 */
	@RequestMapping("/spark/test")
	public String sparkHook( @RequestBody SparkMessage message) {
		tom_logger.info("Incoming Sparks request");

		messages.add( message );
			
		// Send Message
		RestTemplate restTemplate = new RestTemplate( new SparkAuthorizedClientRequestFactory(accessToken) );
		
		
		SparkMessageData messageOut = new SparkMessageData()
				.setText("I received something from : " +  message.getName() )
				.setPersonId(TomBurnley);

    			
		messageOut = restTemplate.postForObject("https://api.ciscospark.com/v1/messages", messageOut, SparkMessageData.class );
											  
		return "This is a String";
	}
	
	@Scheduled( cron="0 * * * * MON-FRI" )
    public void reportCurrentTime() {
		// Send Message
		RestTemplate restTemplate = new RestTemplate( new SparkAuthorizedClientRequestFactory(accessToken) );
		
		
		SparkMessageData message = new SparkMessageData()
				.setText("Hello - I'm alive")
				.setPersonId(TomBurnley);

    			
		message = restTemplate.postForObject("https://api.ciscospark.com/v1/messages", message, SparkMessageData.class );
											  
		tom_logger.info("Posted Test message to : ");
    }
	
	/*
	 * List the messages that I know of.... 
	 */
	@RequestMapping("/spark/messages")
	public @ResponseBody ResponseEntity<List<SparkMessage>> getMessages( ) {
		return new ResponseEntity<List<SparkMessage>> (messages, HttpStatus.OK); 
	}
	
	/*
	 * List the rooms that I know of.... 
	 */
	@RequestMapping("/spark/rooms")
	public @ResponseBody ResponseEntity<List<SparkRoom>> getRooms( ) {
		return new ResponseEntity<List<SparkRoom>> (rooms, HttpStatus.OK); 
	}
	
	/*
	 * List the hooks that I know of.... 
	 */
	@RequestMapping("/spark/webhooks")
	public @ResponseBody ResponseEntity<List<SparkWebhook>> getHooks( ) {
		return new ResponseEntity<List<SparkWebhook>> (webhooks, HttpStatus.OK); 
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		
		tom_logger.debug("After propoerties set - create hook to spark");
		// To obtain a developer access token, visit http://developer.ciscospark.com
        //String accessToken = "MTc0NWU3NjktOGRhMC00ODU0LWI3MTItZjAwNzdlMjE4ZDhhNWUyMzMyZDItYWM1";
        
        HttpHost host = new HttpHost("localhost", 8080, "http");
        
        /**
         * Add access token 
         */
        //AccessTokenRequest atr = new DefaultAccessTokenRequest();
    	//atr.setExistingToken( new DefaultOAuth2AccessToken(accessToken));
        
    	//OAuth2ProtectedResourceDetails details = new SparkProtectedResourceDetails(accessToken );
        //OAuth2RestTemplate restTemplate = new OAuth2RestTemplate( details );
        RestTemplate restTemplate = new RestTemplate( new SparkAuthorizedClientRequestFactory(accessToken) );
        try
        {
	       //List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
	        //messageConverters.add( new SparkCollectionMessageConvertor() );
	        //restTemplate.setMessageConverters(messageConverters);
	        
	        
	        SparkWebHookCollection webhooks = restTemplate.getForObject("https://api.ciscospark.com/v1/webhooks", SparkWebHookCollection.class );
	        tom_logger.info(" Received Webhook : " + webhooks );
	        for ( SparkWebhook hook : webhooks.items ) this.webhooks.add(hook);
	        
	        
	        SparkRoomCollection rooms = restTemplate.getForObject("https://api.ciscospark.com/v1/rooms", SparkRoomCollection.class);
	        tom_logger.info(" Received Rooms : " + rooms );
	        for ( SparkRoom room : rooms.items ) this.rooms.add(room);
	        
	        SparkWebhook my_hook = getHook(this.webhooks, HOOK_NAME);
	        if( my_hook == null ){
	        	tom_logger.warn( "No Registered Hook - Adding... " );
	        	SparkWebhook newHook = new SparkWebhook().setEvent("created")
	        			.setName(HOOK_NAME)
	        			.setTargetUrl("http://staging--shippedapplic--shippedservice--18165a.gce.shipped-cisco.com/spark/test")
	        			.setResource("messages")
	        			.setSecret("pingpong");
	        	
	        	newHook = restTemplate.postForObject("https://api.ciscospark.com/v1/webhooks", newHook, SparkWebhook.class );
	        }
	        else {
	        	tom_logger.warn( "Using Registered hook" );
	        }
	        
	        
	        SparkMessageData message = new SparkMessageData()
					.setText("Starting... ")
					.setPersonId(TomBurnley);
	        
			ResponseEntity<SparkMessageData> response = restTemplate.postForEntity("https://api.ciscospark.com/v1/messages", message, SparkMessageData.class );
			
			tom_logger.info( "Received " + response.getStatusCode() );
	        
	        
        }
        catch( HttpMessageConversionException httpException )
        {
        	tom_logger.error(httpException.getMessage() );
	    }
        
	}
	

	private SparkWebhook getHook(LinkedList<SparkWebhook> webhooks, String name) {
		for( SparkWebhook h : webhooks )
	    	if( h.getName().equals( name ) )
		    	return h;
		return null;
	}
	
	
}
