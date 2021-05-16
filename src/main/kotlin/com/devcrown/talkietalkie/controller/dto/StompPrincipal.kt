package com.devcrown.talkietalkie.controller.dto

import java.security.Principal

class StompPrincipal : Principal {

  private var name: String = ""

  fun setName(name: String) {
    this.name = name
  }

  override fun getName(): String {
    return this.name
  }
}
