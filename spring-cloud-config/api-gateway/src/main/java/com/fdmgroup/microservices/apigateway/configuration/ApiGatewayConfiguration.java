package com.fdmgroup.microservices.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route(predicate -> predicate
										.path("/get")
										.filters(
												filter -> filter.addRequestHeader("My-Header", "value") // for authentication purposes
																.addRequestParameter("request-parameter", "value")
												)
										.uri("http://httpbin.org:80/")) // shows details of your request
				.route(predicate -> predicate
										.path("/currency-exchange/**")
										.uri("lb://currency-exchange"))
				.route(predicate -> predicate
										.path("/currency-conversion/**")
										.uri("lb://currency-conversion"))
//				.route(predicate -> predicate
//										.path("/currency-conversion-new")
//										.filters(
//												filter -> filter.rewritePath("/currency-conversion-new/(?<segment>.*)",
//																			"/currency-conversion-feign/${segment}")
//												)
//										.uri("lb://currency-conversion"))
				.build();
	}
	
}
