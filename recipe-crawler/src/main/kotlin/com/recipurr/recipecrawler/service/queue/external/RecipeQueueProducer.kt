package com.recipurr.recipecrawler.service.queue.external

import com.recipurr.recipecrawler.service.parser.ParsedRecipe
import org.springframework.stereotype.Service

@Service
class RecipeQueueProducer {

    fun sendRecipeToCategorizerQueue(recipe: ParsedRecipe) {
        //TODO will be implemented later
    }
}