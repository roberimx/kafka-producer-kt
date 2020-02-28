package me.tecuani.kafkaproducer.controller

import me.tecuani.kafkaproducer.config.AppProperties
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.util.concurrent.ListenableFutureCallback
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TopicController(
        private val kafkaTemplate: KafkaTemplate<String, String>,
        private val appProperties: AppProperties
) {
    private val log = LoggerFactory.getLogger(TopicController::class.java)

    @GetMapping("/send/{message}")
    fun send(@PathVariable("message") message: String) {

        kafkaTemplate
                .send(appProperties.topic, message)
                .addCallback(object : ListenableFutureCallback<SendResult<String, String>> {

                    override fun onSuccess(result: SendResult<String, String>?) {
                        log.info(result.toString())
                    }

                    override fun onFailure(ex: Throwable) {
                        log.error(ex.message, ex)
                    }

                })

    }

}
