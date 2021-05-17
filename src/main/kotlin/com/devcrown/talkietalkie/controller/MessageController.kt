package com.devcrown.talkietalkie.controller

import com.devcrown.talkietalkie.model.ClientMessage
import java.security.Principal
import java.util.*
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Controller

@Controller
class MessageController(private var hashTagProcessor: HashTagProcessor) {

    @MessageMapping("/hash")
    fun sendMessage(priincipal: Principal, @Payload message: ClientMessage) {
        var hashTag = message.hashTag

        if (hashTag != null) {
            hashTagProcessor.pushData(hashTag, priincipal.getName())
        }
    }
}
