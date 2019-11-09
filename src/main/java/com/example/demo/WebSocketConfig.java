package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.example.demo.resource.DateStreamer;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	
//	@Autowired
//	public DateStreamer dateStreamer;

//	@Override
//	public void registerStompEndpoints(StompEndpointRegistry registry) {
//		registry.addEndpoint("/clock").setAllowedOrigins("*");
//		registry.addEndpoint("/clock").setAllowedOrigins("*").withSockJS();
//	}
//	
//	@Override
//	public void configureMessageBroker(MessageBrokerRegistry registry) {
//		registry.enableSimpleBroker("/topic","/queue");
//		registry.setApplicationDestinationPrefixes("/app");
//	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new DateStreamer(), "/clock");
	}

}
