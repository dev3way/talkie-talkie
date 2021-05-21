package com.devcrown.talkietalkie.controller

import java.security.Principal
import java.util.*
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class MessageController(private var hashTagProcessor: HashTagProcessor) {

    @MessageMapping("/hash/{queueName}/join")
    //    @SendTo("/hash/{queueName}/join")
    fun joinQueue(priincipal: Principal, @DestinationVariable queueName: String) {
        var hashTag = queueName
        if (hashTag != null) {
            hashTagProcessor.pushData(hashTag, priincipal.getName())
            //            return Response.suceessOf()
        }
        //        return Response.failof()
    }

    @MessageMapping("/rooms/{roomId}")
    @SendTo("/topic/rooms/{roomId}")
    fun temp(@DestinationVariable roomId: String, @Payload message: String): Any {
        return message
    }
}
