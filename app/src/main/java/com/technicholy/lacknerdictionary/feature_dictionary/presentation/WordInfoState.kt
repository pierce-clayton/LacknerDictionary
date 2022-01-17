package com.technicholy.lacknerdictionary.feature_dictionary.presentation

import com.technicholy.lacknerdictionary.feature_dictionary.domain.models.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
