package com.cisco.spvss.testProject;

import org.springframework.beans.factory.InitializingBean;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQBroker  implements InitializingBean {

	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		
		
		
		ConnectionFactory factory = new ConnectionFactory();
		
		Connection conn = factory.newConnection( "host", 1000 );
			
	}
	
}
