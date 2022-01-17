package com.technicholy.lacknerdictionary.feature_dictionary.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.technicholy.lacknerdictionary.feature_dictionary.domain.models.Meaning
import com.technicholy.lacknerdictionary.feature_dictionary.domain.models.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String,
    val origin: String,
    val meanings: List<Meaning>,
    @PrimaryKey(autoGenerate = true) val id: Long? = null
){
    fun toWordInfo() = WordInfo(
        meanings,
        origin,
        phonetic,
        word
    )
}
