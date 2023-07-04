package com.dev.mvvm_repos.repository

import com.dev.mvvm_repos.data.model.UserDetailResponse
import com.dev.mvvm_repos.data.model.UserRepositoryResponse
import com.dev.mvvm_repos.data.model.UserResponse
import com.dev.mvvm_repos.data.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepositoryImpl(private val api: ApiService) : UserRepository {
    override suspend fun getListUsers(): List<UserResponse> {
        return withContext(Dispatchers.IO) {
            return@withContext api.getListUsers()
        }
    }

    override suspend fun getUserDetail(user: String): UserDetailResponse {
        return withContext(Dispatchers.IO) {
            return@withContext api.getUserDetail(user)
        }
    }

    override suspend fun getRepositories(user: String): List<UserRepositoryResponse> {
        return withContext(Dispatchers.IO) {
            return@withContext api.getRepositories(user)
        }
    }
}