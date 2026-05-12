package com.lukaveli.stackoverflow.domain.repository

import com.lukaveli.stackoverflow.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<Result<List<User>>>
    suspend fun toggleFollowState(userId: Long)
}
