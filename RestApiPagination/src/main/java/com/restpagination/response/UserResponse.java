package com.restpagination.response;

import java.util.List;

import com.restpagination.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
	
	
	private List<UserDto> content;
	private int pageno;
	private int pagesize;
	private long totalelment;
	private int totalpage;
	private boolean last;
	

}
