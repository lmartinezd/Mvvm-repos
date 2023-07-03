package com.dev.mvvm_repos.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.mvvm_repos.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repo: UserRepository) : ViewModel() {
    private val _viewState = MutableLiveData<UserViewState>()
    val viewState: LiveData<UserViewState> = _viewState

    fun listAllUsers() {
        viewModelScope.launch {
            _viewState.value = UserViewState.Loading
            try {
                var result = repo.getListUsers().toListUsers()

                _viewState.value = UserViewState.Success(result)
            } catch (exception: Throwable) {
                _viewState.value = UserViewState.Failed(exception.message.toString())
            }
        }
    }
}