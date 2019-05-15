package com.kafka.learn.kafkacloudstream;

import com.kafka.learn.kafkacloudstream.service.ChannelConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(ChannelConfig.class)
public class KafkaCloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaCloudStreamApplication.class, args);
	}

}
