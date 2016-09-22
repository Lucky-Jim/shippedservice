package com.cisco.spvss.spark.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SparkMessageData {

		private String id;
		
		private String roomId;
		
		private String personId;
		
		private String personEmail;
		
		private String created;
		
		public String getId() {
			return id;
		}

		public String getPersonID() {
			return personId;
		}
		
		public String getRoomID() {
			return roomId;
		}
		
		public String getPersonEmail() {
			return personEmail;
		}
		
		public String getCreatedDate() {
			return created;
		}
		
		
		
}
