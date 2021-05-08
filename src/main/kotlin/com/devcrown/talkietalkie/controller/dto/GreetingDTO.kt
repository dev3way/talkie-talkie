package com.devcrown.talkietalkie.controller.dto

import java.time.LocalDateTime

class GreetingDTO(
        private var now: LocalDateTime? = null,
        private var content: String? = null
)