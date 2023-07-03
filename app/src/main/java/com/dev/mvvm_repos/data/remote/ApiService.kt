package com.dev.mvvm_repos.data.remote

import com.dev.mvvm_repos.data.model.UserResponse
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getListUsers(): UserResponse
}