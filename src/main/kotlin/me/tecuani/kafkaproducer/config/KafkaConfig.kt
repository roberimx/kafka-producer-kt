package me.tecuani.kafkaproducer.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaConfig(
        private val appProperties: AppProperties
) {

    @Bean
    fun topic() = TopicBuilder
            .name(appProperties.topic)
            .partitions(appProperties.partitions)
            .replicas(appProperties.replicas)
            .build()


}
