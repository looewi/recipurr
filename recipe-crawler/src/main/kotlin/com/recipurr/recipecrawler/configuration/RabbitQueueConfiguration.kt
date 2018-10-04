package src.main.kotlin.com.recipurr.recipecrawler.configuration

import com.recipurr.recipecrawler.service.queue.internal.UrlQueueReceiver
import com.recipurr.recipecrawler.service.queue.internal.UrlQueueSender
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration


@Configuration
class UrlQueueConfiguration {

    @Bean
    fun urlQueue() = Queue("hello")

    @Bean
    fun urlTemplate() = RabbitTemplate()


    @Bean
    fun urlQueueReceiver() = UrlQueueReceiver()


//    @Bean
//    fun urlQueueSender() = UrlQueueSender(urlQueue(), urlTemplate())

}