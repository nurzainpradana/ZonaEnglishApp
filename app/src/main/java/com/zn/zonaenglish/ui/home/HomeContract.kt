package com.zn.zonaenglish.ui.home

import com.zn.zonaenglish.base.BasePresenter
import com.zn.zonaenglish.base.BaseView
import com.zn.zonaenglish.ui.home.infopromo.model.InfoPromoItem
import com.zn.zonaenglish.ui.home.studyvideo.model.StudyVideoResponseItem

class HomeContract {

    interface View : BaseView<Presenter> {
        fun setItemToView(typeStudyVideo: MutableList<StudyVideoResponseItem>)
        fun setInfoPromo(infoPromo: List<InfoPromoItem>)
        fun setError(throwable: Throwable)
    }

    interface ViewInfoPromo : BaseView<Presenter> {
        fun setItemToView(infoPromo: List<InfoPromoItem>)
        fun setError(throwable: Throwable)
    }

    interface Presenter : BasePresenter {
        fun getTypeStudyVideo(apiKey: String)
        fun getInfoPromo(apiKey: String)
    }
}