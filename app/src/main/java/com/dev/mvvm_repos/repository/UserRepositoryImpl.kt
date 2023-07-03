package com.dev.mvvm_repos.repository

import com.dev.mvvm_repos.data.model.UserResponse
import com.dev.mvvm_repos.data.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepositoryImpl(private val api: ApiService) : UserRepository {
    override suspend fun getListUsers(): UserResponse {
        return withContext(Dispatchers.IO) {
            return@withContext api.getListUsers()
        }
    }
}