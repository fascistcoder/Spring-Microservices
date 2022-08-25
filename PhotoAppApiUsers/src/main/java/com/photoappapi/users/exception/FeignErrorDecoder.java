package com.photoappapi.users.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 25/08/22
 */
@AllArgsConstructor
@Component
public class FeignErrorDecoder implements ErrorDecoder {

	private final Environment environment;

	@Override public Exception decode(String methodKey, Response response) {
		switch (response.status()) {
			case 400:
				break;
			case 404:
				if (methodKey.contains("getAlbums")) {
					return new ResponseStatusException(HttpStatus.valueOf(response.status()), environment.getProperty("albums.exception.notfound"));
				}
				break;
			default:
				return new Exception(response.reason());
		}
		return null;
	}
}
