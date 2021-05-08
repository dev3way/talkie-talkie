package com.devcrown.talkietalkie.controller

import com.devcrown.talkietalkie.config.Log
import com.devcrown.talkietalkie.controller.dto.ConnectDTO
import com.devcrown.talkietalkie.controller.dto.Response
import com.sun.jmx.remote.internal.ArrayQueue
import org.springframework.messaging.simp.SimpMessageSendingOperations
import org.springframework.stereotype.Component
import java.util.*
import kotlin.collections.HashMap

@Component
class HashTagProcessor(private val messageTemplate: SimpMessageSendingOperations) {

    companion object {
        private var hashTagMap: HashMap<String, Queue<String>> = TODO()
        private var log: Log

        fun pushData(hashTag: String, userId: String) {
            var q = hashTagMap.getOrDefault(hashTag, mutableListOf<String>())
            q.add(userId)
            //if(두명 넘어가면 바로 리턴)
            send(sender, target)
            send(target, send)
        }
    }


    val thread = Thread(
            Runnable {
                try {
                    //여기에 큐 돌면서 체크하는부분 들어가는 로
                    while(qsize> 2)
                        q poll



                } catch (e: Exception) {
                    log.log.error(e.message)
                }
            }
    )

    fun send(sender: String, target: String) {
        messageTemplate.convertAndSendToUser(sender, "/topic/",
                Response.suceessOf(
                        ConnectDTO(
                                target = target
                        )
                )
        )
    }

}