package com.techprimers.kafka.springbootkafkaproducerexample.resource;

import com.techprimers.kafka.springbootkafkaproducerexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private  KafkaTemplate<String, User> kafkaTemplate;

    private static final String topic = "dec23t";


    @GetMapping("publish/{message}")
    public String post(@PathVariable("message") final String message){

        kafkaTemplate.send(topic , new User(message,"echo",299L));
        return "published successfully";
    }
}
