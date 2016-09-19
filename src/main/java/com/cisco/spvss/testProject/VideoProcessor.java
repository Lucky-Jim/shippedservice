package com.cisco.spvss.testProject;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class VideoProcessor {
	private static final Logger logger = LoggerFactory.getLogger(VideoProcessor.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
	private LinkedList<VideoSegmentInfo> info = new LinkedList<VideoSegmentInfo>();
	private LinkedList<VideoSegment> segments = new LinkedList<VideoSegment>();

	private int sequenceNo = 0;
	
	@Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        publishSegment(sequenceNo++);
    }
	
	/**
	 * 
	 * 
	 **/
	synchronized void publishSegment(int i) {
		info.add( new VideoSegmentInfo( i ) );
        segments.add(new VideoSegment( ) );
        logger.info( "Publishing Segment: " + i );
        
        while( info.size() > 7 )
        	 info.removeFirst();
            
        while( segments.size() > 7 )
        	segments.removeFirst();
        
	}
	
	synchronized public List<VideoSegment> getSegments()
	{
		return segments;
		
	}
	
	synchronized public List<VideoSegmentInfo> getSegmentInfos()
	{
		return info;
	}
	
	synchronized public VideoSegment getSegment(String bitrate, String segment )
	{
		int firstSeg = ( sequenceNo > 7 ? sequenceNo - 7 : 0 );
		
		int index = Integer.valueOf(segment) - firstSeg;
		
		logger.info("Access Index :  " + index );
		
		
		return segments.get(index);
	}

	
	
	
}
