package com.server.WordCounterApplication;

import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

@Controller
public class WebSocketController {
    @MessageMapping("/broadcast")
    @SendTo("/topic/reply")
    //listens to messages published on '/app/broadcast'
    public String broadcast(@Payload String message){
        return "You have received a message: " + message;
    }

    //listens to messages published on '/app/user-message
    @MessageMapping("/user-message")
    @SendTo("/queue/reply")
    public String sendBackToUser(@Payload String message) {
        System.out.println(message);
        return message;
    }
}
