package com.cisco.spvss.spark.model;

public class SparkCollection<T> {

	public T[] items;
	
	public class WebHookCollection 	extends SparkCollection<SparkWebhook>{}
	public class RoomCollection 	extends SparkCollection<SparkRoom>{}
	public class MessageCollection 	extends SparkCollection<SparkMessage>{}

}
