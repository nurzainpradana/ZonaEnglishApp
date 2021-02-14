package com.zn.zonaenglish.repository.homerepository

import android.util.Log
import com.zn.zonaenglish.network.ApiClient
import com.zn.zonaenglish.util.Coroutines

class HomeRemoteDataSource(private val apiClient: ApiClient): HomeDataSource {

    override fun getStudyVideo(apiKey: String, callback: HomeDataSource.LoadHomeCallback) {
        Coroutines.main {
            try {
                val studyVideo = apiClient.getTypeVideo(apiKey)
                val dataResult = studyVideo.data
                callback.onDataLoaded(dataResult)
            } catch (e: Exception) {
                callback.onError(e)
                Log.d("TAG", "getStudyVideo: $e")
            }
        }
    }

    override fun getInfoPromo(apiKey: String, callback: HomeDataSource.LoadInfoPromoCallback) {
        Coroutines.main {
            try {
                val infoPromo = apiClient.getInfoPromo(apiKey)
                val dataResult = infoPromo.data
                callback.onDataLoadedInfoPromo(dataResult ?: return@main)
            } catch (e: java.lang.Exception) {
                callback.onError(e)
            }
        }
    }
}