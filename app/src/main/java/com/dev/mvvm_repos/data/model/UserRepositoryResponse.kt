package com.dev.mvvm_repos.data.model

import com.google.gson.annotations.SerializedName

data class UserRepositoryResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String? = null
)