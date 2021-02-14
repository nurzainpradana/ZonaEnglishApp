package com.zn.zonaenglish.ui.home.studyvideo.detail

import com.zn.zonaenglish.base.BasePresenter
import com.zn.zonaenglish.base.BaseView
import com.zn.zonaenglish.ui.home.studyvideo.model.StudyLevelResponseItem

class DetailStudyContract {

    interface View : BaseView<Presenter> {
        fun setLevelToView(studyLevel: MutableList<StudyLevelResponseItem>)
        fun setError(throwable: Throwable)
    }

    interface Presenter : BasePresenter {
        fun getStudyLevel(code: String)
    }
}