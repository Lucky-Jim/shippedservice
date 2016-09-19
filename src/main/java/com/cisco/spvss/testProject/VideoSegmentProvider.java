package com.cisco.spvss.testProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoSegmentProvider {
	private static final Logger logger = LoggerFactory.getLogger(VideoSegmentProvider.class);

	@Autowired
	ApplicationContext act;

	
	@RequestMapping(value="/video/{assetId}/{bitRate}-fileSequence{sequenceNo}.ts")
	public byte[] requestManifest(	@PathVariable String assetId,
									@PathVariable String bitRate, 
									@PathVariable String sequenceNo) {
		
		VideoProcessor processor = (VideoProcessor)act.getBean( VideoProcessor.class );
		
		logger.info("Incoming data request for Asset: " + assetId + " bitrate: " + bitRate + " sequence: " + sequenceNo);
		
		VideoSegment segment = processor.getSegment( bitRate, sequenceNo );
		
		return segment.getData();
		
	}
	
}
