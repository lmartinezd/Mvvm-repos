package com.dev.mvvm_repos.ui.user

import com.dev.mvvm_repos.data.model.User

sealed class UserViewState {
    data class Success(val listUsers: List<User>) : UserViewState()
    object Loading : UserViewState()
    data class Failed(val error: String) : UserViewState()
}
