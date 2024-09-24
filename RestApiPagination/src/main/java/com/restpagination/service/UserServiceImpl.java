package com.restpagination.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.restpagination.dto.UserDto;
import com.restpagination.entity.User;
import com.restpagination.repository.UserRepository;
import com.restpagination.response.UserResponse;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	// Autowired or create param constructor
//	public UserServiceImpl(UserRepository userRepository) {
//		super();
//		this.userRepository = userRepository;
//	}

	@Override
	public UserDto createUser(UserDto userDto) {

		// convert DTO to entity
		User maptoEntity = maptoEntity(userDto);
		User save = userRepository.save(maptoEntity);

		// convert Entity to Dto
		UserDto mapToDto = mapToDto(save);

		return mapToDto;
	}

	// Convert Entity into DTO
	private UserDto mapToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setContent(user.getContent());
		userDto.setDescription(user.getDescription());
		userDto.setTitle(user.getTitle());

		return userDto;

	}

	// Convert DTO to entity
	private User maptoEntity(UserDto userDto) {

		User user = new User();
		user.setTitle(userDto.getTitle());
		user.setContent(userDto.getContent());
		user.setDescription(userDto.getDescription());
		return user;
	}

	@Override
	public UserResponse getAllUser(int pageno, int pagesize, String sortBy, String sortDir) {
		
	Sort sort =sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		// create Pageable instance
	 Pageable pageable = PageRequest.of(pageno, pagesize,sort);
	 
	 Page<User> userPage = userRepository.findAll(pageable);
	 
	 // get content for page obejct
	 List<User> list = userPage.getContent();
	 
	 List<UserDto> content = list.stream().map(maptoEntity -> mapToDto(maptoEntity)).collect(Collectors.toList());
	 
	 UserResponse userResponse = new UserResponse();
	 userResponse.setContent(content);
	 userResponse.setPageno(userPage.getNumber());
	 userResponse.setPagesize(userPage.getSize());
	 userResponse.setTotalpage(userPage.getTotalPages());
	 userResponse.setTotalelment(userPage.getTotalElements());
	 userResponse.setLast(userPage.isLast());
	 
		return userResponse;
	}

}
