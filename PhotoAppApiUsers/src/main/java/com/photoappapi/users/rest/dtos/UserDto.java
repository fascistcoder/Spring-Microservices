package com.photoappapi.users.rest.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 17/08/22
 */
@Getter
@Setter
public class UserDto implements Serializable {
	@Serial private static final long serialVersionUID = 9209106236064397545L;

	private String firstName;

	private String lastName;

	private String password;

	private String email;

	private String userId;

	private String encryptedPassword;
}
