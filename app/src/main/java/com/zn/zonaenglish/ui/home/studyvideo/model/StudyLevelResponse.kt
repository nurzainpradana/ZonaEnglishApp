package com.zn.zonaenglish.ui.home.studyvideo.model

import com.google.gson.annotations.SerializedName


class StudyLevelResponse : ArrayList<StudyLevelResponseItem>()

data class StudyLevelResponseItem(
    @SerializedName("code") var code: String,
    @SerializedName("hcode") var hcode: String,
    @SerializedName("name") var name: String,
    @SerializedName("remark_1") var remark1: String,
    @SerializedName("remark_2") var remark2: Any
)