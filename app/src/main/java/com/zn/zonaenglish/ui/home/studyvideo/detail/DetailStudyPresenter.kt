package com.zn.zonaenglish.ui.home.studyvideo.detail

import com.zn.zonaenglish.repository.detailstudyrepository.StudyDataSource
import com.zn.zonaenglish.repository.detailstudyrepository.StudyRepository
import com.zn.zonaenglish.ui.home.studyvideo.model.StudyLevelResponseItem

class DetailStudyPresenter(
    private val view: DetailStudyContract.View,
    private val repository: StudyRepository
) : DetailStudyContract.Presenter {

    init {
        this.view.setPresenter(this)
    }

    override fun getStudyLevel(code: String) {
        repository.getStudyLevel(code, object : StudyDataSource.LoadStudyCallback {
            override fun onDataLoaded(studyLevel: MutableList<StudyLevelResponseItem>) {
                view.setLevelToView(studyLevel)
            }

            override fun onError(throwable: Throwable) {
                view.setError(throwable)
            }
        })
    }

    override fun start() {

    }
}