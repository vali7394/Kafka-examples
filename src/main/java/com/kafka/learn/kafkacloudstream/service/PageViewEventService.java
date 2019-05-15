package com.kafka.learn.kafkacloudstream.service;

import com.kafka.learn.kafkacloudstream.domain.PageViewEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.integration.kafka.dsl.Kafka;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by mshaik on 5/14/19.
 */
@Component
@Slf4j
public class PageViewEventService implements ApplicationRunner {

  private final MessageChannel channelConfig;



  public PageViewEventService(ChannelConfig channelConfig){
     this.channelConfig = channelConfig.pageViewOut();
  }



  @Override
  public void run(ApplicationArguments applicationArguments) throws Exception {

    List<String> names = Arrays.asList("vali","meera","Bhavni","Malarapu","cloud","stream");
    List<String> pages = Arrays.asList("web","pdp","gallery","landing","recommendations");

   Runnable runnable =  () -> {

          String name = names.get(new Random().nextInt(names.size()));
          String page = pages.get(new Random().nextInt(pages.size()));

     PageViewEvent viewEvent = new PageViewEvent(name,page,Math.random() > .5 ? 10 : 1000);

     Message<PageViewEvent> message = MessageBuilder.withPayload(viewEvent).setHeader(KafkaHeaders.MESSAGE_KEY,viewEvent
         .getUserName()
         .getBytes())
         .build();
     try {
       this.channelConfig.send(message);
       log.info("Message sent successfully");
     } catch (Exception ex) {
       log.error(ex.getLocalizedMessage());
     }

    };

    Executors.newScheduledThreadPool(1).scheduleAtFixedRate(runnable,1,1, TimeUnit.SECONDS);

  }
}
