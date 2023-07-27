package com.cwacrudapp.demo.controller;

import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cwacrudapp.demo.repository.HttpTraceRepository;

//public class HttpTraceActuatorConfiguration {
//
//}

@Configuration
//@Profile("actuator-endpoints") /* if you want: register bean only if profile is set */
public class HttpTraceActuatorConfiguration {

 @Bean
 public InMemoryHttpTraceRepository httpTraceRepository() {
     return new InMemoryHttpTraceRepository();
 }

}