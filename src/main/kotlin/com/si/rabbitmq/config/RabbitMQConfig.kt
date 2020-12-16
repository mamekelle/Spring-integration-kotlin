package com.si.rabbitmq.config

import com.si.rabbitmq.utils.ApplicationProperties
import org.springframework.amqp.core.*
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {

    @Autowired
    lateinit var applicationProperties: ApplicationProperties

    @Bean
    fun  queue(): Queue{
        return Queue(applicationProperties.queue,true)
    }

    @Bean
    fun exchange(): TopicExchange{
        return TopicExchange(applicationProperties.exchange,true,false)
    }

    @Bean
    fun bindingQuEx(): Binding{
        return BindingBuilder.bind(queue()).to(exchange()).with(applicationProperties.routingKey)
    }

    @Bean
    fun jsonMessageConverter(): MessageConverter{
        return Jackson2JsonMessageConverter()
    }

    @Bean
    fun rabbitTemplate(connectionFactory: ConnectionFactory): RabbitTemplate{
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter=jsonMessageConverter()
        return rabbitTemplate
    }

}