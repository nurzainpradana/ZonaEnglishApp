package com.zn.zonaenglish.repository.homerepository

import com.zn.zonaenglish.ui.home.infopromo.model.InfoPromoItem
import com.zn.zonaenglish.ui.home.studyvideo.model.StudyVideoResponseItem

class HomeRepository(private val homeRemoteDataSource: HomeRemoteDataSource) : HomeDataSource {

    override fun getStudyVideo(apiKey: String, callback: HomeDataSource.LoadHomeCallback) {
        homeRemoteDataSource.getStudyVideo(apiKey,
            object : HomeDataSource.LoadHomeCallback {
            override fun onDataLoaded(studyVideo: MutableList<StudyVideoResponseItem>) {
                callback.onDataLoaded(studyVideo)
            }

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }
        })
    }

    override fun getInfoPromo(apiKey: String, callback: HomeDataSource.LoadInfoPromoCallback) {
        homeRemoteDataSource.getInfoPromo(apiKey,
            object : HomeDataSource.LoadInfoPromoCallback {
                override fun onDataLoadedInfoPromo(infoPromo: List<InfoPromoItem>) {
                    callback.onDataLoadedInfoPromo(infoPromo)
                }

                override fun onError(throwable: Throwable) {
                    callback.onError(throwable)
                }
            })
    }


}