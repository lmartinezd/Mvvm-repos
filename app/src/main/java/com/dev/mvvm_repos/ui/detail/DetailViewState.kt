package com.dev.mvvm_repos.ui.detail

import com.dev.mvvm_repos.data.model.UserDetail
import com.dev.mvvm_repos.data.model.UserRepo

sealed class DetailViewState {
    data class Success(val detail: UserDetail) : DetailViewState()
    data class Failed(val error: String) : DetailViewState()
}