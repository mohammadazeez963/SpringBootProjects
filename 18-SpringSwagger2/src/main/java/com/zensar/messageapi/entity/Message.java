package com.zensar.messageapi.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This class is used to store message information")
public class Message {
			@ApiModelProperty(notes = "This is id information of the message")
			private  int id;
			private String message;
			
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getMessage() {
				return message;
			}
			public void setMessage(String message) {
				this.message = message;
			}
			
			
}
