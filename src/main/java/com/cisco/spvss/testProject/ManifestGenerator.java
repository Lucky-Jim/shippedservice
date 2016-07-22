package com.cisco.spvss.testProject;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManifestGenerator {

	private static final Logger logger = LoggerFactory.getLogger(ManifestGenerator.class);

	
	@RequestMapping(value="/video/{assetId}/manifest.m3u8", produces="application/x-mpegURL")
	
	public String requestManifest(@PathVariable String assetId) {
		logger.info("Incoming manifest request for : " + assetId );

		List<String> response = new LinkedList<String>();
		
		response.add("#EXTM3U\n");
		response.add("\n");
		response.add("#EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=1217000,RESOLUTION=1280x720\n");
		response.add("manifest-1200k.m3u8\n");
		response.add("\n");
		response.add("#EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=824000,RESOLUTION=896x504\n");
		response.add("manifest-800k.m3u8\n");
		response.add("\n");
		response.add("#EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=629000,RESOLUTION=640x360\n");
		response.add("manifest-600k.m3u8\n");
		response.add("\n");
		response.add("#EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=430000,RESOLUTION=512x288\n");
		response.add("manifest-400k.m3u8\n");
		response.add("\n");
		response.add("#EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=216000,RESOLUTION=400x300\n");
		response.add("manifest-200k.m3u8\n");
		response.add("\n");
		response.add("#EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=121000,RESOLUTION=400x300\n");
		response.add("manifest-110k.m3u8\n");
		
		logger.info("REsponse : \n" + String.join("", response) );
		return String.join("", response);
	}
	
	@RequestMapping(value="/video/{assetId}/manifest-{bitrate}.m3u8", produces="application/x-mpegURL")
	public String requestManifest(@PathVariable String assetId ,@PathVariable String bitrate ) {
		
		logger.info("Incoming sub-manifest request for : " + assetId + " bitrate : " + bitrate);

		List<String> response = new LinkedList<String>();
		
		response.add("#EXTM3U\n");
		response.add("\n");

		
		return String.join("", response);
	}
}
