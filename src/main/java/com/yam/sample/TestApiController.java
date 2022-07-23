package com.yam.sample;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping(value = "/web2/api/kafka")
public class TestApiController {
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	
	/**
	 * Post메시지로 Kafka로 전송할(produce) 메시지를 입력 받음
	 * Test producer
	 * @return
	 */
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public @ResponseBody String sendMessage( @RequestBody Map<String, Object> body) {
		log.debug("RequestBody: {}", body);
		
		kafkaProducer.sendMessage(body.toString());
		return "OK";
	}
}
