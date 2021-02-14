package com.zn.zonaenglish.ui.login.loginemail.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("data")
	val user: User? = null,

	@field:SerializedName("meta")
	val meta: Meta? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class User(

	@field:SerializedName("nik")
	val nik: Any? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("photo")
	val photo: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("email_verified_at")
	val emailVerifiedAt: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("no_phone")
	val noPhone: Any? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class Meta(

	@field:SerializedName("token")
	val token: String? = null
)
