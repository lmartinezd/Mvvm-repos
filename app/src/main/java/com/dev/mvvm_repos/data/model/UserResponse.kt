package com.dev.mvvm_repos.data.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("login") val login: String? = null,
    @SerializedName("id") val id: Int,
    @SerializedName("avatar_url") val avatar_url: String? = null,
    @SerializedName("url") val url: String? = null
)