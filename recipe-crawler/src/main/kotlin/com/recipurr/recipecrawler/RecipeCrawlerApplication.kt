package com.recipurr.recipecrawler

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.recipurr.recipecrawler")
class RecipeCrawlerApplication

fun main(args: Array<String>) {
    runApplication<RecipeCrawlerApplication>(*args)
}
