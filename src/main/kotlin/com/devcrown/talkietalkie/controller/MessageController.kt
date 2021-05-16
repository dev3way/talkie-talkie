package com.devcrown.talkietalkie.controller

import com.devcrown.talkietalkie.controller.dto.MessageDTO
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
    fun sendMessage(@PathVariable("test") test: String, @Payload m: MessageDTO): MessageDTO {
        println(test)
        return m
    }
}
