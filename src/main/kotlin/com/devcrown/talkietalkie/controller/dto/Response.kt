package com.devcrown.talkietalkie.controller.dto

class Response<T>(
        private var suceess: Boolean = false,
        private var content : T) {

    companion object{
        fun <T> suceessOf(content: T) :Response<T>{
            return Response<T>(
                    suceess = true,
                    content = content
            )

        }
        fun <T> failOf(content: T) :Response<T>{
            return Response<T>(
                    suceess = false,
                    content = content
            )

        }
    }

}