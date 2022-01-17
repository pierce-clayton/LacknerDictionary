package com.technicholy.lacknerdictionary.feature_dictionary.data.remote.dto

import com.technicholy.lacknerdictionary.feature_dictionary.domain.models.Definition

data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
) {
    fun toDefinition() = Definition(
            antonyms,
            definition,
            example,
            synonyms
        )

}