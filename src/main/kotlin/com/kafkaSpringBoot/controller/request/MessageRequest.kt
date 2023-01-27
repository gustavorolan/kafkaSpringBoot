package com.kafkaSpringBoot.controller.request

import com.fasterxml.jackson.annotation.JsonProperty

data class MessageRequest(
    @JsonProperty("string")
    private val string: String = ""
)
