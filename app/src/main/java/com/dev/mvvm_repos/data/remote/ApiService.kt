package com.dev.mvvm_repos.data.remote

import com.dev.mvvm_repos.data.model.UserDetailResponse
import com.dev.mvvm_repos.data.model.UserRepositoryResponse
import com.dev.mvvm_repos.data.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users")
    suspend fun getListUsers(): List<UserResponse>

    @GET("users/{user}")
    suspend fun getUserDetail(@Path("user") user: String): UserDetailResponse

    @GET("users/{user}/repos")
    suspend fun getRepositories(@Path("user") user: String): List<UserRepositoryResponse>
}