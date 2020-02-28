package me.tecuani.kafkaproducer.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("me.tecuani.kafkaproducer")
data class AppProperties(
        var topic: String = "me.tecuani.demo.kafka.topic",
        var partitions: Int = 2,
        var replicas: Int = 1
)
