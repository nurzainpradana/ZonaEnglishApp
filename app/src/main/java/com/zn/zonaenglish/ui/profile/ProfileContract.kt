package com.zn.zonaenglish.ui.profile

import com.zn.zonaenglish.base.BasePresenter
import com.zn.zonaenglish.base.BaseView
import com.zn.zonaenglish.ui.profile.model.LogoutResponse

class ProfileContract {

    interface View : BaseView<Presenter> {
        fun setMoveToLogin(logoutUser: LogoutResponse)
        fun setError(throwable: Throwable)
    }

    interface Presenter : BasePresenter {
        fun getTypeLogout() {}
    }

}