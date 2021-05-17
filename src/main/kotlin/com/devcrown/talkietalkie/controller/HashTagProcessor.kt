package com.devcrown.talkietalkie.controller

import java.util.LinkedList
import java.util.Queue
import kotlin.collections.HashMap
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Component

@Component
class HashTagProcessor {
    private var messageTemplate: SimpMessagingTemplate

    constructor(messageTemplate: SimpMessagingTemplate) {
        this.messageTemplate = messageTemplate
    }

    private var hashTagMap: HashMap<String, Queue<String>> = HashMap<String, Queue<String>>()

    fun pushData(hashTag: String, userName: String) {
        var que = hashTagMap.getOrDefault(hashTag, LinkedList<String>())
        que.add(userName)
        if (que.size >= 2) {
            val client1 = que.poll()
            val client2 = que.poll()
            send(client1, "moyaho")
            send(client2, "moyaho")
        }
        hashTagMap.set(hashTag, que)
    }

    fun send(target: String, token: String) {

        messageTemplate.convertAndSendToUser(target, "/topic/join", token)
    }
}
