package com.zn.zonaenglish.repository.homerepository

import com.zn.zonaenglish.ui.home.infopromo.model.InfoPromoItem
import com.zn.zonaenglish.ui.home.studyvideo.model.StudyVideoResponseItem

interface HomeDataSource {

    fun getStudyVideo(apiKey: String, callback: LoadHomeCallback)

    fun getInfoPromo(apiKey: String, callback: LoadInfoPromoCallback)

    interface LoadHomeCallback {
        fun onDataLoaded(studyVideo: MutableList<StudyVideoResponseItem>)
        fun onError(throwable: Throwable)
    }

    interface LoadInfoPromoCallback {
        fun onDataLoadedInfoPromo(infoPromo: List<InfoPromoItem>)
        fun onError(throwable: Throwable)
    }
}