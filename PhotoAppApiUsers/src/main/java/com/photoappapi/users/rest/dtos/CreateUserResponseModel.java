package com.photoappapi.users.rest.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 17/08/22
 */
@Getter
@Setter
public class CreateUserResponseModel {
	private String firstName;

	private String lastName;

	private String email;

	private String userId;
}
