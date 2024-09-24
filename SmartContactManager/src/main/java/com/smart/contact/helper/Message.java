package com.smart.contact.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Message {
	
	private String content;
	private String type;
	
	
	public Message(String content, String type) {
		super();
		this.content = content;
		this.type = type;
	}
	
	
	

}
