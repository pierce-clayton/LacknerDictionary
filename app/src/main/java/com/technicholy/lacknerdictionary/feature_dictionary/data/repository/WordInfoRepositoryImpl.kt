package com.technicholy.lacknerdictionary.feature_dictionary.data.repository

import com.technicholy.lacknerdictionary.core.util.Resource
import com.technicholy.lacknerdictionary.feature_dictionary.data.local.dao.WordInfoDao
import com.technicholy.lacknerdictionary.feature_dictionary.data.remote.api.DictionaryApi
import com.technicholy.lacknerdictionary.feature_dictionary.domain.models.WordInfo
import com.technicholy.lacknerdictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
) : WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())
        val wordInfos = dao.getWordInfos(word).map{it.toWordInfo()}
        emit(Resource.Loading(data = wordInfos))
        try{
            val remoteWordInfos = api.getWordInfo(word)
            dao.deleteWordInfos(remoteWordInfos.map{it.word})
            dao.insertWordInfos(remoteWordInfos.map{ it.toWordInfoEntity()})
        }catch (e: HttpException){
            emit(Resource.Error(
                message = "Error with network",
                data = wordInfos
            ))
        }catch (e: IOException){
            emit(Resource.Error(
                message = "No internet connection",
                data = wordInfos
            ))
        }
        val newWordInfos = dao.getWordInfos(word).map {
            it.toWordInfo()
        }
        emit(Resource.Success(newWordInfos))
    }

}