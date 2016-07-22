package com.cisco.spvss.testProject;
/**
	 * "id": "Y2lzY29zcGFyazovL3VzL01FTUJFUlNISVAvYzU0MjdlNjMtYjFlMi00YTkyLWE4YmItMDA0NzFjOGU2ZWEyOjBkMjA0Y2IxLTUwYjctMzY3NS1iYjQ2LWFiMjg2ODFlNjQ0Yg",
			"roomId": "Y2lzY29zcGFyazovL3VzL1JPT00vMGQyMDRjYjEtNTBiNy0zNjc1LWJiNDYtYWIyODY4MWU2NDRi",
			"personId": "Y2lzY29zcGFyazovL3VzL1BFT1BMRS9jNTQyN2U2My1iMWUyLTRhOTItYThiYi0wMDQ3MWM4ZTZlYTI",
			"personEmail": "tburnley@cisco.com",
			"personDisplayName": "Tom Burnley (tburnley)",
			"isModerator": false,
			"isMonitor": false,
			"created": "2016-02-01T16:38:15.531Z"
		
	 */
public class SparkConversation {

	
	private String personEmail;
	private String personId;
	private String roomId;
	private String id;
	
	String getID( ){
		return id;
	}
	
	String roomId( ){
		return roomId;
	}
	
	String personId( ){
		return personId;
	}
	String personEmail( ){
		return personEmail;
	}
	boolean isModerator( ){
		return false;
	}
	boolean isMonitor ( ){
		return false;
	}
	
	
	
}
