package com.devcrown.talkietalkie.config

import java.util.UUID
import org.springframework.http.server.ServerHttpRequest
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.server.support.DefaultHandshakeHandler

class CustomHandshakeHandler : DefaultHandshakeHandler() {
  override protected fun determineUser(
      request: ServerHttpRequest,
      wsHandler: WebSocketHandler,
      attributes: Map<String, Any>
  ): StompPrincipal? {
    val sp = StompPrincipal()

    sp.setName(UUID.randomUUID().toString())

    return sp
  }
}
