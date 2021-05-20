package com.devcrown.talkietalkie.controller

import com.devcrown.talkietalkie.controller.dto.EventType
import com.devcrown.talkietalkie.controller.dto.Response
import com.devcrown.talkietalkie.controller.dto.RoomDTO
import com.devcrown.talkietalkie.model.ClientMessage
import org.springframework.messaging.handler.annotation.DestinationVariable
import java.security.Principal
import java.util.*
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable

@Controller
class MessageController(private var hashTagProcessor: HashTagProcessor) {

    @MessageMapping("/hash/{queueName}/join")
//    @SendTo("/hash/{queueName}/join")
    fun joinQueue(priincipal: Principal, @Payload QueueName: String) {
        var hashTag = QueueName
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
