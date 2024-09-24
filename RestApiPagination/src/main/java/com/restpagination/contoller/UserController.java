package com.restpagination.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restpagination.dto.UserDto;
import com.restpagination.response.AppConstants;
import com.restpagination.response.UserResponse;
import com.restpagination.service.UserService;



@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
//	Now invoke these URLs one by one and observe the outputs.

//	http://localhost:8089/api/user?pageSize=5
//	http://localhost:8089/api/user?pageSize=5&pageNo=1
//	http://localhost:8089/api/user?pageSize=5&pageNo=2
//	http://localhost:8089/api/user?pageSize=5&pageNo=1&sortBy=title
//	http://localhost:8089/api/user?pageSize=5&pageNo=1&sortBy=title&sortDir=asc
	
	
	
	@PostMapping
	ResponseEntity<UserDto>  createUser(@RequestBody UserDto userDto){
		return new ResponseEntity<>(userService.createUser(userDto),HttpStatus.CREATED);
	}
	
	@GetMapping
	public UserResponse getAllUsers(
			@RequestParam(value = "pageno", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER , required = false) int pageno,
			@RequestParam(value = "pagesize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pagesize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY,required = false)String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
             )
			{
		
		
		return userService.getAllUser(pageno, pagesize, sortBy, sortDir);
	}
	
	
	
}
