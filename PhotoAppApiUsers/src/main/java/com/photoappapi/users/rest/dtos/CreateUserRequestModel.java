package com.photoappapi.users.rest.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 17/08/22
 */

@Getter
@Setter
public class CreateUserRequestModel {

	@NotNull(message = "first name can not be null")
	@Size(min = 2, message = "First Name must not be less than two characters")
	private String firstName;

	@NotNull(message = "last name can not be null")
	@Size(min = 2, message = "Last Name must not be less than two characters")
	private String lastName;

	@NotNull(message = "Password can not be null")
	@Size(min = 2, max = 16, message = "Password must be equal or less than 16 characters")
	private String password;

	@NotNull(message = "email can not be null")
	@Email
	private String email;
}
