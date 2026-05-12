package com.lukaveli.stackoverflow.data;

import android.content.Context;
import com.lukaveli.stackoverflow.data.local.FollowPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DataStoreModule_ProvideFollowPreferencesFactory implements Factory<FollowPreferences> {
  private final Provider<Context> contextProvider;

  public DataStoreModule_ProvideFollowPreferencesFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public FollowPreferences get() {
    return provideFollowPreferences(contextProvider.get());
  }

  public static DataStoreModule_ProvideFollowPreferencesFactory create(
      Provider<Context> contextProvider) {
    return new DataStoreModule_ProvideFollowPreferencesFactory(contextProvider);
  }

  public static FollowPreferences provideFollowPreferences(Context context) {
    return Preconditions.checkNotNullFromProvides(DataStoreModule.INSTANCE.provideFollowPreferences(context));
  }
}
