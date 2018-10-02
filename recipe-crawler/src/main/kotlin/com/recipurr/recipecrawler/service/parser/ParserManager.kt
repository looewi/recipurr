package com.recipurr.recipecrawler.service.parser

import org.springframework.stereotype.Service


typealias ParserOutput = Pair<ParsedRecipe?, List<String>>

data class LoadedContent(val sourceUrl: String,
                         val sourceType: String,
                         val html: String)

@Service
class ParserManager() {

    val parsers = listOf<HtmlParser>()

    fun parseLoadedContent(loadedContent: LoadedContent): ParserOutput =
        parsers.firstOrNull { it.parserType == loadedContent.sourceType }?.parseContent(loadedContent) ?: {
            print("No parser found for type ${loadedContent.sourceType}")
            ParserOutput(null, emptyList())
        }()
}