package src.main.kotlin.com.recipurr.recipecrawler.configuration

import com.recipurr.recipecrawler.service.queue.internal.UrlQueueReceiver
import com.recipurr.recipecrawler.service.queue.internal.UrlQueueSender
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


// it'll be better to rename configuration as UrlQueueConfiguration. the same is related to queue, sender, receiver, etc
// we'll have a lot of other queues. it's better to use different files for their configuration
// 1) it's following principle of decoupling code and single-responsibility code
// 2) it's easier to navigate and modify code
// 3) it's easier and safer to remove dependencies which are not needed anymore
//
// so instead of
// @Configuration
// class RabbitQueueConfiguration {
//
// let's do it like (also it's needed to rename a file, but I'll leave it like that for now so you can see just modifications in github
@Configuration
class UrlQueueConfiguration {

    //    @Bean
    //    fun hello() = Queue("hello")
    // beans are accessed in other classes by name. we don't need bean hello which is actually a queue
    // be careful to name beans exactly as they will be used in other classes <3

    // also it'll be better to configure queue name from .yml configuration but we can leave a
    // hardcoded "hello" value for now
    @Bean
    fun urlQueue() = Queue("hello")

    @Bean
    fun urlTemplate() = RabbitTemplate()


    //    @Profile("receiver") <- and no profiles
    //    @Bean
    //    fun receiver() = Receiver()
    //
    // ofc class Receiver can't be found
    // this is not a class from a library, this is our own class which is responsible for receiving messages
    // so in our case it'll be UrlQueueReceiver
    // so code will be
    @Bean
    fun urlQueueReceiver() = UrlQueueReceiver()


    //    @Profile("sender")
    //    @Bean
    //    fun sender(template: RabbitTemplate, queue: Queue) = Sender(template, queue)
    //
    // the same with sender
    // BUT also
    // sender(template: RabbitTemplate, queue: Queue)
    // you see that we need to pass RabbitTemplate and Queue as dependencies
    // so you also need to create them as beans otherwise spring won't find autowired objects of this type
    // bean for sender will look like this (queue is created in line 33, template - line 37)
    @Bean
    fun urlQueueSender(urlQueue: Queue, urlTemplate: RabbitTemplate) = UrlQueueSender(urlQueue, urlTemplate)

}