package com.photoappapi.users.service;

import com.photoappapi.users.rest.dtos.UserDto;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 17/08/22
 */
public interface UserService {
	UserDto createUser(UserDto userDetails);
}
