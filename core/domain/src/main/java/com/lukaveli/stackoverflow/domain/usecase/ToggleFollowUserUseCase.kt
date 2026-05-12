package com.lukaveli.stackoverflow.domain.usecase

import com.lukaveli.stackoverflow.domain.repository.UserRepository
import javax.inject.Inject

class ToggleFollowUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userId: Long) {
        userRepository.toggleFollowState(userId)
    }
}
