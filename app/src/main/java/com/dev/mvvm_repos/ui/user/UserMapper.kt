package com.dev.mvvm_repos.ui.user

import com.dev.mvvm_repos.data.model.*

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

fun List<UserRepositoryResponse>.toListUserRepositories() =
    map {
        UserRepo(
            name = it.name ?: "",
            id = it.id
        )
    }.toMutableList()