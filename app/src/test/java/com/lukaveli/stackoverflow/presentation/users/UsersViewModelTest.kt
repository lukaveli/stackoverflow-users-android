package com.lukaveli.stackoverflow.presentation.users

import app.cash.turbine.test
import com.lukaveli.stackoverflow.MainDispatcherRule
import com.lukaveli.stackoverflow.domain.model.User
import com.lukaveli.stackoverflow.domain.usecase.GetUsersUseCase
import com.lukaveli.stackoverflow.domain.usecase.ToggleFollowUserUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UsersViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var getUsersUseCase: GetUsersUseCase
    private lateinit var toggleFollowUserUseCase: ToggleFollowUserUseCase
    private lateinit var viewModel: UsersViewModel

    private val mockUser = User(1L, "Jon Skeet", 1000000L, "url", false)

    @Before
    fun setUp() {
        getUsersUseCase = mockk()
        toggleFollowUserUseCase = mockk(relaxed = true)
    }

    @Test
    fun `loadUsers emits Success state when use case returns data`() = runTest {
        // Arrange
        val expectedUsers = listOf(mockUser)
        coEvery { getUsersUseCase() } returns flowOf(Result.success(expectedUsers))

        // Act
        viewModel = UsersViewModel(getUsersUseCase, toggleFollowUserUseCase)

        // Assert
        viewModel.state.test {
            val state = awaitItem()
            assertTrue(state is UsersContract.State.Success)
            assertEquals(expectedUsers, (state as UsersContract.State.Success).users)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `loadUsers emits Error state when use case returns failure`() = runTest {
        // Arrange
        val errorMessage = "Network error"
        coEvery { getUsersUseCase() } returns flowOf(Result.failure(Exception(errorMessage)))

        // Act
        viewModel = UsersViewModel(getUsersUseCase, toggleFollowUserUseCase)

        // Assert
        viewModel.state.test {
            val state = awaitItem()
            assertTrue(state is UsersContract.State.Error)
            assertEquals(errorMessage, (state as UsersContract.State.Error).message)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `toggleFollow calls use case and does not crash`() = runTest {
        // Arrange
        coEvery { getUsersUseCase() } returns flowOf(Result.success(emptyList()))
        viewModel = UsersViewModel(getUsersUseCase, toggleFollowUserUseCase)

        // Act
        viewModel.handleEvent(UsersContract.Event.ToggleFollow(1L))

        // Assert
        coVerify(exactly = 1) { toggleFollowUserUseCase(1L) }
    }
}
