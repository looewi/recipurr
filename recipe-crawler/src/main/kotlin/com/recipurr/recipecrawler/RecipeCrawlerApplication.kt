package com.recipurr.recipecrawler

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RecipeCrawlerApplication

fun main(args: Array<String>) {
    runApplication<RecipeCrawlerApplication>(*args)
}
