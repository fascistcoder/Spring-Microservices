package com.photoappapi.users.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Users implements Serializable {

	@Serial private static final long serialVersionUID = -6796723332961118658L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 50)
	private String firstName;

	@Column(nullable = false, length = 50)
	private String lastName;

	@Column(nullable = false, length = 120, unique = true)
	private String email;

	@Column(nullable = false, unique = true)
	private String userId;

	@Column(nullable = false, unique = true)
	private String encryptedPassword;

}
