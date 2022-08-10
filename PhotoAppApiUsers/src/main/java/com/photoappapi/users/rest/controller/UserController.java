package com.photoappapi.users.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 12/06/22
 */
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

	private Environment env;

	@GetMapping("/status/check")
	public String status(){
		return "Working on port " + env.getProperty("local.server.port");
	}
}
