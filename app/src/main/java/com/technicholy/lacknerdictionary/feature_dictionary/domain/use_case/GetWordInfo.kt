package com.technicholy.lacknerdictionary.feature_dictionary.domain.use_case

import com.technicholy.lacknerdictionary.core.util.Resource
import com.technicholy.lacknerdictionary.feature_dictionary.domain.models.WordInfo
import com.technicholy.lacknerdictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class GetWordInfo(
    private val repository: WordInfoRepository
) {
    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>>{
        if(word.isBlank()){
            return emptyFlow()
        }
        return repository.getWordInfo(word)
    }
}