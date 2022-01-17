package com.technicholy.lacknerdictionary.feature_dictionary.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.technicholy.lacknerdictionary.feature_dictionary.data.local.dao.WordInfoDao
import com.technicholy.lacknerdictionary.feature_dictionary.data.local.entities.WordInfoEntity
import com.technicholy.lacknerdictionary.feature_dictionary.data.local.type_converters.Converters

@Database(
    entities = [WordInfoEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase: RoomDatabase() {
    abstract val dao: WordInfoDao
}