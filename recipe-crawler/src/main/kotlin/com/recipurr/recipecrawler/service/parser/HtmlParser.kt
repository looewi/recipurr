package com.recipurr.recipecrawler.service.parser

data class ParsedRecipe(val title: String,
                        val ingredients: List<Ingredient>,
                        val directions: List<String>,
                        val imgSource: String?,
                        val type: String,
                        val url: String)

data class Ingredient(val ingredientName: String,
                      val measureUnit: String? = null,
                      val amount: Int? = null)

abstract class HtmlParser {

    abstract val parserType: String

    abstract fun parseContent(loadedContent: LoadedContent): ParserOutput

}