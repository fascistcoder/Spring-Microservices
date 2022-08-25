package com.photo.api.photoapp.Model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 25/08/22
 */
@Getter
@Setter
public class Albums {
	private long id;
	private String albumId;
	private String userId;
	private String name;
	private String description;
}
