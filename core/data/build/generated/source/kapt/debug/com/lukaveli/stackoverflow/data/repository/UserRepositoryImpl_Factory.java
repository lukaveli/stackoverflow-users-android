package com.lukaveli.stackoverflow.data.repository;

import com.lukaveli.stackoverflow.data.local.FollowPreferences;
import com.lukaveli.stackoverflow.data.remote.StackOverflowApi;
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
public final class UserRepositoryImpl_Factory implements Factory<UserRepositoryImpl> {
  private final Provider<StackOverflowApi> apiProvider;

  private final Provider<FollowPreferences> followPreferencesProvider;

  public UserRepositoryImpl_Factory(Provider<StackOverflowApi> apiProvider,
      Provider<FollowPreferences> followPreferencesProvider) {
    this.apiProvider = apiProvider;
    this.followPreferencesProvider = followPreferencesProvider;
  }

  @Override
  public UserRepositoryImpl get() {
    return newInstance(apiProvider.get(), followPreferencesProvider.get());
  }

  public static UserRepositoryImpl_Factory create(Provider<StackOverflowApi> apiProvider,
      Provider<FollowPreferences> followPreferencesProvider) {
    return new UserRepositoryImpl_Factory(apiProvider, followPreferencesProvider);
  }

  public static UserRepositoryImpl newInstance(StackOverflowApi api,
      FollowPreferences followPreferences) {
    return new UserRepositoryImpl(api, followPreferences);
  }
}
