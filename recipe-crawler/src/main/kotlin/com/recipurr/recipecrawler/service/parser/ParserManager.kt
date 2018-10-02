package com.recipurr.recipecrawler.service.parser

import com.recipurr.recipecrawler.service.queue.external.RecipeQueueProducer
import com.recipurr.recipecrawler.service.queue.internal.UrlQueueProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


typealias ParserOutput = Pair<ParsedRecipe?, List<String>>

data class LoadedContent(val sourceUrl: String,
                         val sourceType: String,
                         val html: String)

@Service
class ParserManager(@Autowired var urlQueueProducer: UrlQueueProducer,
                    @Autowired var recipeQueueProducer: RecipeQueueProducer) {

    val parsers = listOf<HtmlParser>()

    fun processContent(loadedContent: LoadedContent) {
        fun parseLoadedContent(loadedContent: LoadedContent) =
                parsers.find { it.parserType == loadedContent.sourceType }?.parseContent(loadedContent) ?: {
                    print("No parser found for type ${loadedContent.sourceType}")
                    ParserOutput(null, emptyList())
                }()

        val (recipe, relatedLinks) = parseLoadedContent(loadedContent)
        recipe?.let {
            recipeQueueProducer.sendRecipeToCategorizerQueue(it)
        }
        urlQueueProducer.addLinksToQueue(relatedLinks)

    }
}