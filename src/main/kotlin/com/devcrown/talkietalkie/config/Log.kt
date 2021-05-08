package com.devcrown.talkietalkie.config

import org.slf4j.LoggerFactory
import java.util.logging.Logger

interface Log {
    val log: org.slf4j.Logger get() = LoggerFactory.getLogger(this.javaClass)
}