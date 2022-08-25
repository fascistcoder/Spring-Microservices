package com.photoappapi.users.rest.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 25/08/22
 */
@Getter
@Setter
public class UserResponseModel {
	private String firstName;
	private String lastName;
	private String email;
	private String userId;
	private List<AlbumResponseModel> albumResponseModels = new ArrayList<>();
}
