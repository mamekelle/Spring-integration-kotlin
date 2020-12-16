package com.si.rabbitmq.utils

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class ApplicationProperties {

    @Value("\${si.rabbitmq.exchange}")
    lateinit var exchange: String

    @Value("\${si.rabbitmq.queue}")
    lateinit var queue: String

    @Value("\${si.rabbitmq.routingkey}")
    lateinit var routingKey: String

}