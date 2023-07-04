package com.dev.mvvm_repos.repository

import com.dev.mvvm_repos.data.model.UserDetailResponse
import com.dev.mvvm_repos.data.model.UserRepositoryResponse
import com.dev.mvvm_repos.data.model.UserResponse

interface UserRepository {
    suspend fun getListUsers(): List<UserResponse>
    suspend fun getUserDetail(user: String): UserDetailResponse
    suspend fun getRepositories(user: String): List<UserRepositoryResponse>
}