package com.lukaveli.stackoverflow.domain.usecase

import com.lukaveli.stackoverflow.domain.model.User
import com.lukaveli.stackoverflow.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(): Flow<Result<List<User>>> {
        return userRepository.getUsers()
    }
}
