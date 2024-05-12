package parniyan.mahmoudroid.compose.base.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import parniyan.mahmoudroid.compose.base.data.repository.BaseRepositoryImpl
import parniyan.mahmoudroid.compose.base.domain.repository.BaseRepository
import parniyan.mahmoudroid.compose.base.presentation.handler.UniversalEventHandler
import javax.inject.Singleton

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */
@InstallIn(SingletonComponent::class)
@Module
abstract class BaseModule {

    companion object {
        @Singleton
        @Provides
        fun provideUniversalEventHandler(): UniversalEventHandler {
            return UniversalEventHandler()
        }
    }

    @Binds
    abstract fun bindBaseRepository(impl: BaseRepositoryImpl): BaseRepository
}