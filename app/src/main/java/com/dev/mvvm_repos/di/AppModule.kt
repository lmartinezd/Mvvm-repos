package com.dev.mvvm_repos.di

import com.dev.mvvm_repos.data.remote.ApiService
import com.dev.mvvm_repos.repository.UserRepository
import com.dev.mvvm_repos.repository.UserRepositoryImpl
import com.dev.mvvm_repos.ui.user.UserViewModel
import com.google.gson.GsonBuilder
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://api.github.com/"

val appModule = module {
    single { getApiService() }
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
    viewModelOf(::UserViewModel)
}

fun getApiService(): ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()
    return retrofit.create(ApiService::class.java)
}