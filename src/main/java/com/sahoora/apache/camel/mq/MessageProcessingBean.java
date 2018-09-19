package com.sahoora.apache.camel.mq;

public class MessageProcessingBean {

	public String processToDB(String body) {
		//1. convert json to Java
		//2. call JPA to persist/update
		return "Message processed to DB successfully!!!";
	}
}
