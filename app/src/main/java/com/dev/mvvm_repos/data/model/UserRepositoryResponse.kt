package com.dev.mvvm_repos.data.model

import com.google.gson.annotations.SerializedName

data class UserRepositoryResponse(
    @SerializedName("login") val login: String? = null,
    @SerializedName("id") val id: Int,
    @SerializedName("avatar_url") val avatarUrl: String? = null,
    @SerializedName("url") val url: String? = null
)