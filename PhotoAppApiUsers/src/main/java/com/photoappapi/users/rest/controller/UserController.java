package com.photoappapi.users.rest.controller;

import com.photoappapi.users.rest.dtos.CreateUserRequestModel;
import com.photoappapi.users.rest.dtos.UserDto;
import com.photoappapi.users.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 12/06/22
 */
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

	@Autowired
	private Environment env;

	private final UserService userService;

	@GetMapping("/status/check")
	public String status(){
		return "Working on port " + env.getProperty("local.server.port");
	}

	@PostMapping
	public ResponseEntity createUser(@Valid @RequestBody CreateUserRequestModel createUserRequestModel){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(createUserRequestModel, UserDto.class);
		userService.createUser(userDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
