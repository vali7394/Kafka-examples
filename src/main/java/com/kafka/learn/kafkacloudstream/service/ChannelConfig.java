package com.kafka.learn.kafkacloudstream.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by mshaik on 5/14/19.
 */
public interface ChannelConfig {

  String PAGE_VIEW_OUT = "pageviewout";

  String PAGE_VIEW_IN = "pageviewin";

  @Output(PAGE_VIEW_OUT)
  MessageChannel pageViewOut();

 // SubscribableChannel pageViewIn();

}
