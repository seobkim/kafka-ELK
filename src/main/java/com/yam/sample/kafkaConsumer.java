package com.yam.sample;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class kafkaConsumer {

	// 그룹이 같으면 나눠서 받음
	@KafkaListener(topics = "exam", groupId = "foo")
	public void consumeFoo(String message) throws IOException{
		log.info("AAAAAA foo-0 Recieve message : {}", message);
	}
	
	@KafkaListener(topics = "exam", groupId = "foo")
	public void consumeFoo1(String message) throws IOException{
		log.info("AAAAAA foo-1 Recieve message : {}", message);
	}
	

	// 그룹이 다르면 함께 받음
	@KafkaListener(topics = "exam", groupId = "bar")
	public void consumeBar(String message) throws IOException{
		log.info("BBBBBB bar Recieve message : {}", message);
	}




}
