package com.technicholy.lacknerdictionary.feature_dictionary.data.remote.dto

import com.technicholy.lacknerdictionary.feature_dictionary.data.local.entities.WordInfoEntity

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val word: String
){
    fun toWordInfoEntity() = WordInfoEntity(
        meanings = meanings.map{it.toMeaning()},
        origin = origin,
        phonetic = phonetic,
        word = word
    )
}