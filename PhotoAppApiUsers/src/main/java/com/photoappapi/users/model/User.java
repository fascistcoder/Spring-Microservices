package com.photoappapi.users.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 17/08/22
 */
@Getter
@Setter
@Entity
@Table
public class User implements Serializable {

	@Serial private static final long serialVersionUID = -6796723332961118658L;

	@Id
	private Long id;

	private String firstName;

	private String lastName;

	private String password;

	private String email;

	private String userId;

	private String encryptedPassword;

}
