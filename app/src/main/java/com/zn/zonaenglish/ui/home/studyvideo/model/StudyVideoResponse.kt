package com.zn.zonaenglish.ui.home.studyvideo.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class StudyVideoResponse(

    @field:SerializedName("code")
	val code: Int? = null,

    @field:SerializedName("data")
	val data: MutableList<StudyVideoResponseItem>,

    @field:SerializedName("message")
	val message: String? = null
)

@Parcelize
data class StudyVideoResponseItem(

	@field:SerializedName("code")
	val code: String,

	@field:SerializedName("remark_2")
	val remark2: String? = null,

	@field:SerializedName("remark_1")
	val remark1: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("hcode")
	val hcode: String? = null
) : Parcelable
