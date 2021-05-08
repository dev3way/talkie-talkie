package com.devcrown.talkietalkie.controller

import com.devcrown.talkietalkie.config.Log
import com.devcrown.talkietalkie.controller.dto.GreetingDTO
import com.devcrown.talkietalkie.controller.dto.Response
import com.devcrown.talkietalkie.model.ClientMessage
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.stereotype.Controller
import org.springframework.web.util.HtmlUtils
import java.time.LocalDateTime
import java.util.*

@Controller
class MessageController() {
    companion object : Log

    @MessageMapping("/join")
    fun joining(message: ClientMessage, header: SimpMessageHeaderAccessor): Response<GreetingDTO> {
        if (Objects.isNull(message.hashTag) || Objects.isNull(header.user))
            return Response.failOf( GreetingDTO()
            )
        log.info("message received, message:{}", message.message)
        HashTagProcessor.pushData(message.hashTag!!, header.user!!.name)
        Thread.sleep(1000) // simulated delay
        return Response.suceessOf( GreetingDTO(
                content = HtmlUtils.htmlEscape(message.message.toString()),
                now = LocalDateTime.now())
        )
    }
}