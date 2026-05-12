package com.lukaveli.stackoverflow.core.data;

import com.lukaveli.stackoverflow.core.data.remote.StackOverflowApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
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
public final class NetworkModule_ProvideStackOverflowApiFactory implements Factory<StackOverflowApi> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideStackOverflowApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public StackOverflowApi get() {
    return provideStackOverflowApi(retrofitProvider.get());
  }

  public static NetworkModule_ProvideStackOverflowApiFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideStackOverflowApiFactory(retrofitProvider);
  }

  public static StackOverflowApi provideStackOverflowApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideStackOverflowApi(retrofit));
  }
}
