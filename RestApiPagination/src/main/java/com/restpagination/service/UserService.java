package com.restpagination.service;

import com.restpagination.dto.UserDto;
import com.restpagination.response.UserResponse;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	UserResponse getAllUser(int pageno, int pagesize, String sortBy, String sortDir);
}
