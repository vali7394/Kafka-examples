package com.kafka.learn.kafkacloudstream.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mshaik on 5/14/19.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageViewEvent {

  private String userName,page;
  private long duration;

}
