package com.photoappapi.users.rest.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 18/08/22
 */
@Getter
@Setter
public class LoginRequestModel {
	private String email;
	private String password;
}
