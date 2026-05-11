package com.lukaveli.stackoverflow.presentation.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lukaveli.stackoverflow.domain.usecase.GetUsersUseCase
import com.lukaveli.stackoverflow.domain.usecase.ToggleFollowUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val toggleFollowUserUseCase: ToggleFollowUserUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<UsersContract.State>(UsersContract.State.Loading)
    val state: StateFlow<UsersContract.State> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<UsersContract.Effect>()
    val effect = _effect.asSharedFlow()

    init {
        handleEvent(UsersContract.Event.LoadUsers)
    }

    fun handleEvent(event: UsersContract.Event) {
        when (event) {
            is UsersContract.Event.LoadUsers -> loadUsers()
            is UsersContract.Event.ToggleFollow -> toggleFollow(event.userId)
        }
    }

    private fun loadUsers() {
        viewModelScope.launch {
            getUsersUseCase()
                .onStart { _state.value = UsersContract.State.Loading }
                .catch { exception ->
                    _state.value = UsersContract.State.Error(exception.message ?: "An unknown error occurred")
                }
                .collect { result ->
                    result.fold(
                        onSuccess = { users ->
                            _state.value = UsersContract.State.Success(users)
                        },
                        onFailure = { exception ->
                            _state.value = UsersContract.State.Error(exception.message ?: "An unknown error occurred")
                        }
                    )
                }
        }
    }

    private fun toggleFollow(userId: Long) {
        viewModelScope.launch {
            try {
                toggleFollowUserUseCase(userId)
            } catch (e: Exception) {
                _effect.emit(UsersContract.Effect.ShowToast("Failed to toggle follow status"))
            }
        }
    }
}
