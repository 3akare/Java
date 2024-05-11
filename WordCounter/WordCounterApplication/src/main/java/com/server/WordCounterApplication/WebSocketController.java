package com.server.WordCounterApplication;

import com.server.WordCounterApplication.TextProcessing.TextProcessing;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Map;

@Controller
public class WebSocketController {
//    @MessageMapping("/broadcast")
//    @SendTo("/topic/reply")
//    //listens to messages published on '/app/broadcast'
//    public String broadcast(@Payload String message){
//        return "You have received a message: " + message;
//    }

    //listens to messages published on '/app/user-message
    @MessageMapping("/user-message")
    @SendToUser("/queue/reply")
    public Map<String,Integer> sendBackToUser(@Payload String message) {
        TextProcessing textProcessing = new TextProcessing();
        if (!message.isEmpty())  textProcessing.setMessage(message);
        return textProcessing.outPut();
    }
}
