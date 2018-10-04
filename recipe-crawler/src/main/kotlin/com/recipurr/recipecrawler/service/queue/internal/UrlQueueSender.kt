package com.recipurr.recipecrawler.service.queue.internal

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired


// we need dependencies for the queue so let's add it here to the class constructor
// bean 'urlQueueSender' is an instance of this class so it'll accept these parameters to constructor
class UrlQueueSender(@Autowired urlQueue: Queue,
                     @Autowired urlTemplate: RabbitTemplate) {

    fun addLinksToQueue(links: List<UrlQueueItem>) {

    }
}