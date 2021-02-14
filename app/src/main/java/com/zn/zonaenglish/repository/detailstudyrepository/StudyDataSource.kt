package com.zn.zonaenglish.repository.detailstudyrepository

import com.zn.zonaenglish.ui.home.studyvideo.model.StudyLevelResponseItem

interface StudyDataSource {

    fun getStudyLevel(code: String, callback: LoadStudyCallback)

    interface LoadStudyCallback {
        fun onDataLoaded(studyLevel: MutableList<StudyLevelResponseItem>)
        fun onError(throwable: Throwable)
    }
}