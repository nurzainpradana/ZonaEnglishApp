package com.zn.zonaenglish.repository.profilerepository

import com.zn.zonaenglish.ui.profile.model.LogoutResponse

class ProfileRepository(private val profileRemoteRepository: ProfileRemoteRepository): ProfileDataSource {

    override fun getLogoutUser(callback: ProfileDataSource.LoadLogoutCallback) {
        profileRemoteRepository.getLogoutUser(object : ProfileDataSource.LoadLogoutCallback{
            override fun onSuccess(logout: LogoutResponse) {
                callback.onSuccess(logout)
            }

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }
        })
    }
}