package com.rto.properties;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * this class is used to as cache like on startup of application all the message which
 * is avilable in yaml file store in map object and provide those message to other clasess 
 * 
 * @author RahulKumar
 *
 */
@Component
@ConfigurationProperties(prefix = "form-app")
public class AppProperties {
	/**
	 * this is used like a cache
	 */
	private Map<String, String> messages;

	public Map<String, String> getMessages() {
		return messages;
	}

	public void setMessages(Map<String, String> messages) {
		this.messages = messages;
	}
	
	
}
