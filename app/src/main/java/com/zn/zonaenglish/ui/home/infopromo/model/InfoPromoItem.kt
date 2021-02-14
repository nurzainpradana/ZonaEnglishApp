package com.zn.zonaenglish.ui.home.infopromo.model


import com.google.gson.annotations.SerializedName

data class InfoPromoItem(
    @SerializedName("code") val code: String?,
    @SerializedName("expired_date") val expiredDate: String?,
    @SerializedName("picture") val picture: String?,
    @SerializedName("remark_1") val remark1: Any?,
    @SerializedName("sk") val sk: String?,
    @SerializedName("subtitle") val subtitle: String?,
    @SerializedName("title") val title: String?
)