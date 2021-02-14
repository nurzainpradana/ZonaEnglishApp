package com.zn.zonaenglish.ui.profile.model


import com.google.gson.annotations.SerializedName

data class LogoutResponse(
    @field:SerializedName("message") val message: String?
)