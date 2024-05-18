package parniyan.mahmoudroid.compose.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import parniyan.mahmoudroid.compose.local.AppCacheDatabase
import parniyan.mahmoudroid.compose.local.AppDatabase
import javax.inject.Singleton

/**
 * this class is contain hilt needed bindings and provides
 */
private const val AppDatabaseName = "parniyan.mahmoud.db"

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {


    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, AppDatabaseName)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideAppCacheDatabase(@ApplicationContext context: Context): AppCacheDatabase {
        return Room.inMemoryDatabaseBuilder(context, AppCacheDatabase::class.java)
            .fallbackToDestructiveMigration()
            .build()
    }


}