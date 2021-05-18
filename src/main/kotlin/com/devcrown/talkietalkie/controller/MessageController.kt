package com.devcrown.talkietalkie.controller

import com.devcrown.talkietalkie.model.ClientMessage
import java.security.Principal
import java.util.*
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable

@Controller
class MessageController(private var hashTagProcessor: HashTagProcessor) {

    @MessageMapping("/hash")
    fun sendMessage(priincipal: Principal, @Payload message: ClientMessage) {
        var hashTag = message.hashTag

        if (hashTag != null) {
            hashTagProcessor.pushData(hashTag, priincipal.getName())
        }
    }

    @MessageMapping("/room/{token}")
    @SendTo("/topic/room/{token}")
    fun temp(@PathVariable token: String, @Payload message: ClientMessage): Any {
        return message
    }
}
