package com.technicholy.lacknerdictionary.feature_dictionary.domain.models

data class WordInfo(
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val word: String
)