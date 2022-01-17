package com.technicholy.lacknerdictionary.feature_dictionary.data.remote.dto

import com.technicholy.lacknerdictionary.feature_dictionary.domain.models.Meaning

data class MeaningDto(
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String
) {
    fun toMeaning() = Meaning(
        definitions.map { it.toDefinition() },
        partOfSpeech
    )
}