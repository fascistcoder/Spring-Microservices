package com.photoappapi.users.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.photoappapi.users.rest.dtos.LoginRequestModel;
import com.photoappapi.users.rest.dtos.UserDto;
import com.photoappapi.users.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.InvalidKeyException;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 18/08/22
 */

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final UserService userService;
	private final Environment environment;

	public AuthenticationFilter(AuthenticationManager authenticationManager, UserService userService,
			Environment environment) {
		super(authenticationManager);
		this.userService = userService;
		this.environment = environment;
	}

	@Override public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		try {
			LoginRequestModel credentials = new ObjectMapper().readValue(request.getInputStream(), LoginRequestModel.class);

			return getAuthenticationManager().authenticate(
					new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
			throws IOException, ServletException, InvalidKeyException {

		String userName = ((User) authResult.getPrincipal()).getUsername();
		UserDto userDto = userService.getUserDetailsByEmail(userName);

		String token = Jwts.builder()
				.setSubject(userDto.getUserId())
				.setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(Objects.requireNonNull(environment.getProperty("token.expiration_time")))))
				.signWith(SignatureAlgorithm.HS512, environment.getProperty("token.secret"))
				.compact();

		response.addHeader("token", token);
		response.addHeader("userId", userDto.getUserId());

	}
}
