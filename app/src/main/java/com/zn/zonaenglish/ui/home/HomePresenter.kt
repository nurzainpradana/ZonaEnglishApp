package com.zn.zonaenglish.ui.home

import com.zn.zonaenglish.repository.homerepository.HomeDataSource
import com.zn.zonaenglish.repository.homerepository.HomeRepository
import com.zn.zonaenglish.ui.home.infopromo.model.InfoPromoItem
import com.zn.zonaenglish.ui.home.studyvideo.model.StudyVideoResponseItem

class HomePresenter(
    private val view: HomeContract.View,
    private val repository: HomeRepository
) : HomeContract.Presenter {

    init {
        this.view.setPresenter(this)
    }

    override fun getTypeStudyVideo(apiKey: String) {
        repository.getStudyVideo(apiKey, object : HomeDataSource.LoadHomeCallback {
            override fun onDataLoaded(studyVideo: MutableList<StudyVideoResponseItem>) {
                view.setItemToView(studyVideo)
            }

            override fun onError(throwable: Throwable) {
                view.setError(throwable)
            }
        })
    }

    override fun getInfoPromo(apiKey: String) {
        repository.getInfoPromo(apiKey, object : HomeDataSource.LoadInfoPromoCallback {
            override fun onDataLoadedInfoPromo(infoPromo: List<InfoPromoItem>) {
                view.setInfoPromo(infoPromo)
            }

            override fun onError(throwable: Throwable) {
                view.setError(throwable)
            }
        })
    }

    override fun start() {
        //Not Action
    }
}