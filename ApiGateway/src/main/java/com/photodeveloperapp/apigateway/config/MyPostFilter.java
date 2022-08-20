package com.photodeveloperapp.apigateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 20/08/22
 */
@Component
@Slf4j
public class MyPostFilter implements GlobalFilter {
	@Override public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		return chain.filter(exchange).then(Mono.fromRunnable(()->{
			log.info("Global post filter executed...");
		}));
	}
}
