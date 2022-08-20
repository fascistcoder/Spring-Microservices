package com.photodeveloperapp.apigateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 20/08/22
 */
@Configuration
@Slf4j
public class GlobalFiltersConfiguration {

	@Order(1)
	@Bean
	public GlobalFilter secondPreFilter(){
		return ((exchange, chain) -> {
			log.info("My second global pre-filter is executed....");
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				log.info("My third global post-filter is executed....");
			}));
		});
	};

	@Order(2)
	@Bean
	public GlobalFilter thirdPreFilter(){
		return ((exchange, chain) -> {
			log.info("My Third global pre-filter is executed....");
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				log.info("My second global post-filter is executed....");
			}));
		});
	};

	@Order(3)
	@Bean
	public GlobalFilter fourthPreFilter(){
		return ((exchange, chain) -> {
			log.info("My Fourth global pre-filter is executed....");
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				log.info("My first global post-filter is executed....");
			}));
		});
	};
}
