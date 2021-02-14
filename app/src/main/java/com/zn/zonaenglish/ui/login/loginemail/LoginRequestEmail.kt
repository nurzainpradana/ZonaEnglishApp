package com.zn.zonaenglish.ui.login.loginemail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginRequestEmail(
    @field:SerializedName("email")
    val email: String? = null,
) : Parcelable