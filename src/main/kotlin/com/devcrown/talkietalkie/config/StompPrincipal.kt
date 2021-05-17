package com.devcrown.talkietalkie.config

import java.security.Principal

class StompPrincipal : Principal {

  private var name: String = ""
  constructor(name: String) {
    this.name = name
  }
  fun setName(name: String) {
    this.name = name
  }

  override fun getName(): String {
    return this.name
  }
}
