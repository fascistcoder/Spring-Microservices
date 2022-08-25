package com.photo.api.photoapp.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 25/08/22
 */
@Getter
@Setter
public class AlbumResponseDto {
	private String albumId;
	private String userId;
	private String name;
	private String description;
}
