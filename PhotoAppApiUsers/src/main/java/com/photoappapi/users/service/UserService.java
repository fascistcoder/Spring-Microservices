package com.photoappapi.users.service;

import com.photoappapi.users.rest.dtos.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 17/08/22
 */
public interface UserService extends UserDetailsService {
	UserDto createUser(UserDto userDetails);
	UserDto getUserDetailsByEmail(String email);
}
