package com.dev.mvvm_repos.repository

import com.dev.mvvm_repos.data.model.UserResponse

interface UserRepository {
    suspend fun getListUsers(): List<UserResponse>
}