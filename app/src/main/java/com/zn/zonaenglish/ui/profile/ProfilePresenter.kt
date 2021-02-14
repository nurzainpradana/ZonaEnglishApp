package com.zn.zonaenglish.ui.profile

import com.zn.zonaenglish.repository.profilerepository.ProfileDataSource
import com.zn.zonaenglish.repository.profilerepository.ProfileRepository
import com.zn.zonaenglish.ui.profile.model.LogoutResponse

class ProfilePresenter(
    private val view: ProfileContract.View,
    private val repository: ProfileRepository
) : ProfileContract.Presenter {

    init {
        this.view.setPresenter(this)
    }

    override fun getTypeLogout() {
        repository.getLogoutUser(object : ProfileDataSource.LoadLogoutCallback{
            override fun onSuccess(logout: LogoutResponse) {
                view.setMoveToLogin(logout)
            }

            override fun onError(throwable: Throwable) {
                view.setError(throwable)
            }
        })
    }

    override fun start() {
        TODO("Not yet implemented")
    }
}