package com.devcrown.talkietalkie.controller.dto

data class RoomDTO(
        var type: EventType,
        var roomId: String,
        var sender: String?,
)
