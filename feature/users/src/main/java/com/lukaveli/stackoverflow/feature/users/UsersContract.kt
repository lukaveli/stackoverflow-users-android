package com.lukaveli.stackoverflow.feature.users

import com.lukaveli.stackoverflow.core.domain.model.User

object UsersContract {
    sealed class State {
        object Loading : State()
        data class Success(val users: List<User>) : State()
        data class Error(val message: String) : State()
    }

    sealed class Event {
        object LoadUsers : Event()
        data class ToggleFollow(val userId: Long) : Event()
    }

    sealed class Effect {
        data class ShowToast(val message: String) : Effect()
    }
}
