package com.restful.response;

import java.util.List;

import com.restful.config.SwaggerConfiguration;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
 