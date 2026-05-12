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
public final class GetUsersUseCase_Factory implements Factory<GetUsersUseCase> {
  private final Provider<UserRepository> userRepositoryProvider;

  public GetUsersUseCase_Factory(Provider<UserRepository> userRepositoryProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
  }

  @Override
  public GetUsersUseCase get() {
    return newInstance(userRepositoryProvider.get());
  }

  public static GetUsersUseCase_Factory create(Provider<UserRepository> userRepositoryProvider) {
    return new GetUsersUseCase_Factory(userRepositoryProvider);
  }

  public static GetUsersUseCase newInstance(UserRepository userRepository) {
    return new GetUsersUseCase(userRepository);
  }
}
