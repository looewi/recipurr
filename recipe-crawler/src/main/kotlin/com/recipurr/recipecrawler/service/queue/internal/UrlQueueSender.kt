package com.recipurr.recipecrawler.service.queue.internal

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service


// we need dependencies for the queue so let's add it here to the class constructor
// bean 'urlQueueSender' is an instance of this class so it'll accept these parameters to constructor
@Service
class UrlQueueSender {

//    @Autowired @Qualifier("urlQueue") lateinit var urlQueue: Queue
//
//    @Autowired lateinit var urlTemplate: RabbitTemplate

    fun addLinksToQueue(links: List<UrlQueueItem>) {

    }
}