package com.lukaveli.stackoverflow.data;

@dagger.Module()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/lukaveli/stackoverflow/data/DataStoreModule;", "", "<init>", "()V", "provideFollowPreferences", "Lcom/lukaveli/stackoverflow/data/local/FollowPreferences;", "context", "Landroid/content/Context;", "data_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DataStoreModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.lukaveli.stackoverflow.data.DataStoreModule INSTANCE = null;
    
    private DataStoreModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.lukaveli.stackoverflow.data.local.FollowPreferences provideFollowPreferences(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}