package com.devcrown.talkietalkie.controller.dto

data class RoomDTO (
    var event: EventType,
    var roomId: String,
    var sender: String?,
)