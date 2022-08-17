package com.photoappapi.users.service.impl;

import com.photoappapi.users.model.Users;
import com.photoappapi.users.repository.UsersRepository;
import com.photoappapi.users.rest.dtos.UserDto;
import com.photoappapi.users.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 17/08/22
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UsersRepository usersRepository;
	@Override public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Users users = modelMapper.map(userDetails, Users.class);
		users.setEncryptedPassword("test");
		usersRepository.save(users);
		return null;
	}
}
