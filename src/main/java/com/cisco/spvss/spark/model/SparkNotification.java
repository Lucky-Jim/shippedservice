package com.cisco.spvss.spark.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author tburnley
 *
 *
 *{
  "id":"Y2lzY29zcGFyazovL3VzL1dFQkhPT0svZjRlNjA1NjAtNjYwMi00ZmIwLWEyNWEtOTQ5ODgxNjA5NDk3",
  "name":"Guild Chat to http://requestb.in/1jw0w3x1",
  "resource":"messages",
  "event":"created",
  "filter":"roomId=Y2lzY29zcGFyazovL3VzL1JPT00vY2RlMWRkNDAtMmYwZC0xMWU1LWJhOWMtN2I2NTU2ZDIyMDdi",
  "data":{
    "id":"Y2lzY29zcGFyazovL3VzL01FU1NBR0UvMzIzZWUyZjAtOWFhZC0xMWU1LTg1YmYtMWRhZjhkNDJlZjlj",
    "roomId":"Y2lzY29zcGFyazovL3VzL1JPT00vY2RlMWRkNDAtMmYwZC0xMWU1LWJhOWMtN2I2NTU2ZDIyMDdi",
    "personId":"Y2lzY29zcGFyazovL3VzL1BFT1BMRS9lM2EyNjA4OC1hNmRiLTQxZjgtOTliMC1hNTEyMzkyYzAwOTg",
    "personEmail":"person@example.com",
    "created":"2015-12-04T17:33:56.767Z"
  }
  
  or ... 
  
  {  "id":"Y2lzY29zcGFyazovL3VzL1dFQkhPT0svMWQzZjMwOTAtODAwYi00Njc1LTgxMDEtMGI4OGU5NWY5ZDU5",
     "name":"TomBot",
     "resource":"messages",
     "event":"created",
     
     .... missing - filter.
     ??
     "actorId":"Y2lzY29zcGFyazovL3VzL1BFT1BMRS9hMDI1YTdhNS1lN2NkLTQ3OWItOWUwMi0xZTMwNTEzOGIzMjc",
     "targetUrl":"http://staging--shippedapplic--shippedservice--18165a.gce.shipped-cisco.com/spark/test",
     "created":"2016-09-22T15:16:25.070Z",
     
     
     "data": 
     {"id":"Y2lzY29zcGFyazovL3VzL01FU1NBR0UvYmIzZjJkYzAtODU5NS0xMWU2LWE2MmEtMTViOTljM2MwNzcw",
     "roomId":"Y2lzY29zcGFyazovL3VzL1JPT00vZGQ1MTcxYmItOTYwNC0zOWU3LTgyODAtM2ZkMzM1ZDZhZGQ2",
     "roomType":"direct",
     "personId":"Y2lzY29zcGFyazovL3VzL1BFT1BMRS9hMDI1YTdhNS1lN2NkLTQ3OWItOWUwMi0xZTMwNTEzOGIzMjc",
     "personEmail":"tom-bot@sparkbot.io",
     "created":"2016-09-28T16:08:01.948Z"
  }
}
  
} 
 */
public class SparkNotification extends SparkObject {

	
	private String name;
	
	private String resource;
	
	private String event;
	
	private String filter;
	
	@JsonProperty("data")
	private SparkMessageData data;
	
	
	public SparkMessageData getMessageData()
	{
		return this.data;
	}
	
	public SparkNotification setMessageData(SparkMessageData data)
	{
		this.data = data;
		return this;
	}

	public String getFilter()
	{
		return this.filter;
	}
	
	public SparkNotification setFilter(String filter)
	{
		this.filter = filter;
		return this;
	}
	
	
	public String getEvent()
	{
		return this.event;
	}
	
	public SparkNotification setEvent(String event)
	{
		this.event = event;
		return this;
	}
	
	
	public String getResource()
	{
		return this.resource;
	}
	
	public SparkNotification setResource(String resource)
	{
		this.resource = resource;
		return this;
	}
	
	
	public String getName()
	{
		return this.name;
	}
	
	public SparkNotification setName(String name)
	{
		this.name = name;
		return this;
	}
	
	
}
