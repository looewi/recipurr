package src.main.kotlin.com.recipurr.recipecrawler.configuration

@Profile("!usage_message")
@Configuration
class RabbitQueueConfiguration {
    @Bean
    fun hello() = Queue("hello")

    @Profile("receiver")
    @Bean
    fun receiver() = Receiver()

    @Profile("sender")
    @Bean
    fun sender(template: RabbitTemplate, queue: Queue) = Sender(template, queue)
}