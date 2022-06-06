package com.zensar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;

@Configuration
public class ApiGatewayConfiguration {
		
		@Bean
		public HttpClient webClient() {
			return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
		}
}
