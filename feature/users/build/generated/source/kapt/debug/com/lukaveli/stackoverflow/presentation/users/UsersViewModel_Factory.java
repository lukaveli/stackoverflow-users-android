package com.lukaveli.stackoverflow.presentation.users;

import com.lukaveli.stackoverflow.domain.usecase.GetUsersUseCase;
import com.lukaveli.stackoverflow.domain.usecase.ToggleFollowUserUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class UsersViewModel_Factory implements Factory<UsersViewModel> {
  private final Provider<GetUsersUseCase> getUsersUseCaseProvider;

  private final Provider<ToggleFollowUserUseCase> toggleFollowUserUseCaseProvider;

  public UsersViewModel_Factory(Provider<GetUsersUseCase> getUsersUseCaseProvider,
      Provider<ToggleFollowUserUseCase> toggleFollowUserUseCaseProvider) {
    this.getUsersUseCaseProvider = getUsersUseCaseProvider;
    this.toggleFollowUserUseCaseProvider = toggleFollowUserUseCaseProvider;
  }

  @Override
  public UsersViewModel get() {
    return newInstance(getUsersUseCaseProvider.get(), toggleFollowUserUseCaseProvider.get());
  }

  public static UsersViewModel_Factory create(Provider<GetUsersUseCase> getUsersUseCaseProvider,
      Provider<ToggleFollowUserUseCase> toggleFollowUserUseCaseProvider) {
    return new UsersViewModel_Factory(getUsersUseCaseProvider, toggleFollowUserUseCaseProvider);
  }

  public static UsersViewModel newInstance(GetUsersUseCase getUsersUseCase,
      ToggleFollowUserUseCase toggleFollowUserUseCase) {
    return new UsersViewModel(getUsersUseCase, toggleFollowUserUseCase);
  }
}
