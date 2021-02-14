package com.zn.zonaenglish.repository.profilerepository

import android.content.Context
import com.zn.zonaenglish.hawkstorage.HawkStorage
import com.zn.zonaenglish.network.ApiClient
import com.zn.zonaenglish.util.Coroutines

class ProfileRemoteRepository(private val apiClient: ApiClient, private val context: Context?): ProfileDataSource {

    override fun getLogoutUser(callback: ProfileDataSource.LoadLogoutCallback) {
        Coroutines.main {
            try {
                val token = HawkStorage.instance(context).getToken()
                val userLogout = apiClient.logoutUser("Bearer $token")
                callback.onSuccess(userLogout)
            } catch (e: Exception) {
                callback.onError(e)
            }
        }
    }
}