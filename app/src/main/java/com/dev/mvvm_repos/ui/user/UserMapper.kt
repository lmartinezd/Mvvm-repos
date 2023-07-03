package com.dev.mvvm_repos.ui.user

import com.dev.mvvm_repos.data.model.User
import com.dev.mvvm_repos.data.model.UserResponse

fun List<UserResponse>.toListUsers() =
    map {
        User(
            it.login ?: "",
            it.id,
            it.avatarUrl ?: "",
            it.url ?: ""
        )
    }.toMutableList()