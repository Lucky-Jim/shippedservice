package com.cisco.spvss.spark.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author tburnley
 *
 *"data":{
    "id":"Y2lzY29zcGFyazovL3VzL01FU1NBR0UvMzIzZWUyZjAtOWFhZC0xMWU1LTg1YmYtMWRhZjhkNDJlZjlj",
    "roomId":"Y2lzY29zcGFyazovL3VzL1JPT00vY2RlMWRkNDAtMmYwZC0xMWU1LWJhOWMtN2I2NTU2ZDIyMDdi",
    "personId":"Y2lzY29zcGFyazovL3VzL1BFT1BMRS9lM2EyNjA4OC1hNmRiLTQxZjgtOTliMC1hNTEyMzkyYzAwOTg",
    "personEmail":"person@example.com",
    "created":"2015-12-04T17:33:56.767Z"
  }
  
  
   Response when creating a message:
   
	"id": "Y2lzY29zcGFyazovL3VzL01FU1NBR0UvNTE0MmEzYzAtODE5OS0xMWU2LWE3MzEtZjcyMmNjNGY0YWY0",
	"roomId": "Y2lzY29zcGFyazovL3VzL1JPT00vMGQxZDBlMjAtNjkxMC0xMWU2LThlOTYtZTk5MTJjMTM3ODU3",
	"roomType": "group",
	"text": "TomBot here - I'm still alive",
	"personId": "Y2lzY29zcGFyazovL3VzL1BFT1BMRS9hMDI1YTdhNS1lN2NkLTQ3OWItOWUwMi0xZTMwNTEzOGIzMjc",
	"personEmail": "tom-bot@sparkbot.io",
	"created": "2016-09-23T14:23:37.468Z"

  
 */



@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SparkMessageData {

		private String id;
		
		private String roomId;
		
		@JsonProperty("toPersonId")
		private String personId;
		
		private String personEmail;
		
		private String text;
		
		private String created;
		
		public String getId() {
			return id;
		}

		public String getPersonId() {
			return personId;
		}
		
		public SparkMessageData setPersonId(String personId) {
			this.personId = personId;
			return this;
		}
		
		public String getRoomId() {
			return roomId;
		}
		
		public SparkMessageData setRoomId(String roomId) {
			this.roomId = roomId;
			return this;
		}
		
		public String getPersonEmail() {
			return personEmail;
		}
		
		public String getCreatedDate() {
			return created;
		}
		
		public SparkMessageData setText(String message) {
			this.text = message;
			return this;
		}
		
		public String getText( ) {
			return text;
		}
		
}
