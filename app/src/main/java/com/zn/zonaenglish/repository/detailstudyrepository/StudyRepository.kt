package com.zn.zonaenglish.repository.detailstudyrepository

import com.zn.zonaenglish.ui.home.studyvideo.model.StudyLevelResponseItem

class StudyRepository(private val studyRemoteDataSource: StudyRemoteDataSource) : StudyDataSource {

    override fun getStudyLevel(code: String, callback: StudyDataSource.LoadStudyCallback) {
        studyRemoteDataSource.getStudyLevel(code, object : StudyDataSource.LoadStudyCallback {
            override fun onDataLoaded(studyLevel: MutableList<StudyLevelResponseItem>) {
                callback.onDataLoaded(studyLevel)
            }

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }
        })
    }
}