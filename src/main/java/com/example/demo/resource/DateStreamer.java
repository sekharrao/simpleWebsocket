package com.example.demo.resource;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;



@Component
@Slf4j
public class DateStreamer extends TextWebSocketHandler{
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		session.sendMessage(new TextMessage("server time : "));
		
		while(Objects.nonNull(session) && session.isOpen()){
		log.debug("publishing the time ....." + LocalDateTime.now(Clock.systemUTC()).format(DateTimeFormatter.ISO_LOCAL_TIME));
		
		session.sendMessage(new TextMessage(LocalDateTime.now(Clock.systemUTC()).format(DateTimeFormatter.ISO_LOCAL_TIME)));
	
		Thread.sleep(5000);
		}
		
	}
}
