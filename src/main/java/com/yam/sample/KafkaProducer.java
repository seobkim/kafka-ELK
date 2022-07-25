package com.yam.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 카프카 프로듀서 셈플
 *
 */

@Service
@Slf4j
public class KafkaProducer {
	private static final String TOPIC = "exam";
    private final KafkaTemplate<String, String> kafkaTemplate;	//applicaton.properties에서 기본값 정의됨
    
    @Autowired
    public KafkaProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    
    
    /**
     * 카프카로 데이터를 넣는다.
     * @param message
     */
    public void sendMessage(String message) {
        log.debug("Produce message : {}", message);
        this.kafkaTemplate.send(TOPIC, message);
    }
    
}
