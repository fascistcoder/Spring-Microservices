package com.photodeveloperapp.apigateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Set;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 20/08/22
 */
@Component
@Slf4j
public class MyPreFilter implements GlobalFilter, Ordered {
	@Override public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("My first Pre-filter is executed .....");

		String requestPath = exchange.getRequest().getPath().toString();
		log.info("Request path = " + requestPath);

		HttpHeaders headers = exchange.getRequest().getHeaders();
		Set<String> headerNames = headers.keySet();

		headerNames.forEach((headerName) -> {
			String headerValue = headers.getFirst(headerName);
			log.info("Header value = " + headerValue);
		});

		return chain.filter(exchange);
	}

	@Override public int getOrder() {
		return 0;
	}
}
