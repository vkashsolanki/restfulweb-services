package com.restful.response;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {

	private String message;
	private String status;
	private boolean success;
	private int statusCode;
	private List<?> body;
	
	
	
	
	public ApiResponse(String message, String status, boolean success, int statusCode, List<?> body) {
		super();
		this.message = message;
		this.status = status;
		this.success = success;
		this.statusCode = statusCode;
		this.body = body;
	}




	public ApiResponse(String message, String status, boolean success, int statusCode) {
		super();
		this.message = message;
		this.status = status;
		this.success = success;
		this.statusCode = statusCode;
	}
	



}
