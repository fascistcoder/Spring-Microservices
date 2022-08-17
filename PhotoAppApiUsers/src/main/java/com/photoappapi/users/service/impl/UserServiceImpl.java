package com.photoappapi.users.service.impl;

import com.photoappapi.users.rest.dtos.UserDto;
import com.photoappapi.users.service.UserService;

import java.util.UUID;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 17/08/22
 */
public class UserServiceImpl implements UserService {

	@Override public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		return null;
	}
}
