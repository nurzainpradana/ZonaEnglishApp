package com.zn.zonaenglish.repository.profilerepository

import com.zn.zonaenglish.ui.profile.model.LogoutResponse

interface ProfileDataSource {

    fun getLogoutUser(callback: LoadLogoutCallback)

    interface LoadLogoutCallback {
        fun onSuccess(logout: LogoutResponse)
        fun onError(throwable: Throwable)
    }
}