package com.zn.zonaenglish.network

import com.zn.zonaenglish.ui.home.infopromo.model.InfoPromoResponse
import com.zn.zonaenglish.ui.home.studyvideo.model.StudyLevelResponse
import com.zn.zonaenglish.ui.home.studyvideo.model.StudyVideoResponse
import com.zn.zonaenglish.ui.login.loginemail.model.LoginResponse
import com.zn.zonaenglish.ui.profile.model.LogoutResponse
import com.zn.zonaenglish.util.Const.API_KEY
import retrofit2.Call
import retrofit2.http.*

interface ApiClient {

    @GET("gettypevideolist")
    suspend fun getTypeVideo(
        @Query("api_token") apiToken: String = API_KEY
    ): StudyVideoResponse

    @GET("getlevel")
    suspend fun getLevel(
        @Query("code") code: String
    ): StudyLevelResponse

    /**
     * Info and Promo
     */
    @GET("getinfopromolist")
    suspend fun getInfoPromo(
        @Query("api_token") apiToken: String = API_KEY
    ): InfoPromoResponse

    /**
     * User Register, Login and Logout
     */
    @GET("auth/register")
    fun registerUser(
        @Body body: String
    ): LoginResponse

    @Headers("Accept:application/json", "Content-type:application/json")
    @POST("auth/loginEmail")
    fun loginEmailRequest(
        @Body body: String
    ): Call<LoginResponse>

    @Headers("Accept:application/json", "Content-type:application/json")
    @POST("auth/login")
    fun loginRequest(
        @Body body: String
    ): Call<LoginResponse>

    @Headers("Accept:application/json", "Content-type:application/json")
    @POST("auth/logout")
    fun logoutUser(
        @Header("Authorization") tokenUser: String
    ): LogoutResponse

}