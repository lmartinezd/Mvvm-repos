package com.dev.mvvm_repos.ui.user

import com.dev.mvvm_repos.data.model.User
import com.dev.mvvm_repos.data.model.UserDetail
import com.dev.mvvm_repos.data.model.UserDetailResponse
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

fun UserDetailResponse.toUserDetail(): UserDetail {
    return UserDetail(
        login = login ?: "",
        id = id,
        avatarUrl = avatarUrl ?: "",
        name = name ?: "",
        company = company ?: "",
        blog = blog ?: "",
        location = location ?: "",
        publicRepos = publicRepos
    )
}