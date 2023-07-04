package com.dev.mvvm_repos.data.model

import com.google.gson.annotations.SerializedName

data class UserDetailResponse(
    @SerializedName("login") val login: String? = null,
    @SerializedName("id") val id: Int,
    @SerializedName("avatar_url") val avatarUrl: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("company") val company: String? = null,
    @SerializedName("blog") val blog: String? = null,
    @SerializedName("location") val location: String? = null,
    @SerializedName("public_repos") val publicRepos: Int,
)