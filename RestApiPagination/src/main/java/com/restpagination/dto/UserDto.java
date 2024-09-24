package com.restpagination.dto;


import lombok.Data;

@Data
public class UserDto {
	
	private Long id;
	private String title;
	private String description;
	private String content; 
	
	//private Set<CommentDto> comments;

}
