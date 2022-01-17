package com.technicholy.lacknerdictionary.feature_dictionary.domain.repository

import com.technicholy.lacknerdictionary.core.util.Resource
import com.technicholy.lacknerdictionary.feature_dictionary.domain.models.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
    fun getWordInfo(word:String): Flow<Resource<List<WordInfo>>>
}