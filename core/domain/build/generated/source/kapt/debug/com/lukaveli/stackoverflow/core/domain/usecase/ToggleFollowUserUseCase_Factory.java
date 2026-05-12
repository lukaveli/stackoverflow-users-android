package com.lukaveli.stackoverflow.core.domain.usecase;

import com.lukaveli.stackoverflow.core.domain.repository.UserRepository;
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
public final class ToggleFollowUserUseCase_Factory implements Factory<ToggleFollowUserUseCase> {
  private final Provider<UserRepository> userRepositoryProvider;

  public ToggleFollowUserUseCase_Factory(Provider<UserRepository> userRepositoryProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
  }

  @Override
  public ToggleFollowUserUseCase get() {
    return newInstance(userRepositoryProvider.get());
  }

  public static ToggleFollowUserUseCase_Factory create(
      Provider<UserRepository> userRepositoryProvider) {
    return new ToggleFollowUserUseCase_Factory(userRepositoryProvider);
  }

  public static ToggleFollowUserUseCase newInstance(UserRepository userRepository) {
    return new ToggleFollowUserUseCase(userRepository);
  }
}
