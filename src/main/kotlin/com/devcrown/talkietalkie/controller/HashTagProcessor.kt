package com.devcrown.talkietalkie.controller

import com.devcrown.talkietalkie.controller.dto.EventType
import com.devcrown.talkietalkie.controller.dto.RoomDTO
import java.util.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.user.SimpUserRegistry
import org.springframework.stereotype.Component

@Component
class HashTagProcessor {
    private var messageTemplate: SimpMessagingTemplate
    @Autowired private val simpUserRegistry: SimpUserRegistry? = null

    constructor(messageTemplate: SimpMessagingTemplate) {
        this.messageTemplate = messageTemplate
    }

    private var hashTagMap: HashMap<String, Queue<String>> = HashMap<String, Queue<String>>()
    private val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    fun pushData(hashTag: String, userName: String) {
        var que = hashTagMap.getOrDefault(hashTag, LinkedList<String>())
        que.add(userName)
        if (que.size >= 2) {
            val client1 = que.poll()
            val client2 = que.poll()

            val randomString =
                    (1..10)
                            .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
                            .map(charPool::get)
                            .joinToString("")

            var message1: RoomDTO = RoomDTO(EventType.master, randomString, client1)
            var message2: RoomDTO = RoomDTO(EventType.joined, randomString, client2)

            if (simpUserRegistry?.getUser(client1) == null) {
                que.add(client2)
            } else if (simpUserRegistry?.getUser(client2) == null) {
                que.add(client1)
            } else {
                send(client1, message1)
                send(client2, message2)
            }
        }
        hashTagMap.set(hashTag, que)
    }

    fun send(target: String, message: RoomDTO) {
        messageTemplate.convertAndSendToUser(target, "/topic/rooms/join", message)
    }
}
