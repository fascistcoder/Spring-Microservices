package com.photoapp.accountmanagement.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 12/06/22
 */
@RestController
@RequestMapping("/account")
public class AccountController {

	@GetMapping("/status/check")
	public String status(){
		return "Working..";
	}
}
