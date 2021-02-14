package com.zn.zonaenglish.ui.home.infopromo.model


import com.google.gson.annotations.SerializedName

data class InfoPromoResponse(
    @SerializedName("code") val code: Int?,
    @SerializedName("data") val data: List<InfoPromoItem>?,
    @SerializedName("message") val message: String?
)