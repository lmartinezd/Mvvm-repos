package com.dev.mvvm_repos.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.mvvm_repos.repository.UserRepository
import com.dev.mvvm_repos.ui.user.toUserDetail
import kotlinx.coroutines.launch

class UserDetailViewModel(private val repo: UserRepository) : ViewModel() {

    private val _viewState = MutableLiveData<DetailViewState>()
    val viewState: LiveData<DetailViewState> = _viewState

    fun getUserDetails(user: String) {
        viewModelScope.launch {
            try {
                var result = repo.getUserDetail(user).toUserDetail()

                _viewState.value = DetailViewState.Success(result)
            } catch (exception: Throwable) {
                _viewState.value = DetailViewState.Failed(exception.message.toString())
            }
        }
    }
}