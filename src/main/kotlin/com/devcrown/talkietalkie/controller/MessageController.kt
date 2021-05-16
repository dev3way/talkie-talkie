package com.devcrown.talkietalkie.controller

import com.devcrown.talkietalkie.model.ClientMessage
import java.util.*
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable

@Controller
class MessageController() {

    @MessageMapping("/{test}")
    @SendTo("/topic/{test}")
    fun sendMessage(@PathVariable("test") test: String, @Payload m: ClientMessage): ClientMessage {
        println(test)
        return m
    }
}
