package com.zn.zonaenglish.repository.detailstudyrepository

import com.zn.zonaenglish.network.ApiClient
import com.zn.zonaenglish.util.Coroutines
import java.lang.Exception

class StudyRemoteDataSource(private val apiClient: ApiClient): StudyDataSource {

    override fun getStudyLevel(code: String, callback: StudyDataSource.LoadStudyCallback) {
        Coroutines.main {
            try {
                val studyLevel = apiClient.getLevel(code)
                callback.onDataLoaded(studyLevel)
            } catch (e: Exception) {
                callback.onError(e)
            }
        }
    }
}