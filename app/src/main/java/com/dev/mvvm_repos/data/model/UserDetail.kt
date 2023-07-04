package com.dev.mvvm_repos.data.model

data class UserDetail (
    val login: String = "",
    val id: Int = 0,
    val avatarUrl: String = "",
    val name: String = "",
    val company: String = "",
    val blog: String = "",
    val location: String = "",
    val publicRepos: Int = 0
)