package parniyan.mahmoudroid.compose.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.work.WorkManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import parniyan.mahmoudroid.compose.R
import parniyan.mahmoudroid.compose.base.domain.error.ErrorHandler
import parniyan.mahmoudroid.compose.base.domain.error.Errors
import javax.inject.Singleton


/**
 ** Created by Parniyan on 5/10/2024.
 **
 */
/**
 * this class is contain hilt needed bindings and provides
 */

private const val UserPreferences = "user_preferences"

@InstallIn(SingletonComponent::class)
@Module
abstract class AppModule {
    companion object {
        @Singleton
        @Provides
        fun provideWorkManager(@ApplicationContext context: Context): WorkManager {
            return WorkManager.getInstance(context)
        }

        /**
         * provides ErrorHandler for different locales
         */

        @Singleton
        @Provides
        fun provideErrorHandler(@ApplicationContext context: Context): ErrorHandler {
            val errors = Errors(
                ioErrorMessage = context.getString(R.string.io_error_message),
                networkErrorMessage = context.getString(R.string.network_error_message),
                serverErrorMessage = context.getString(R.string.server_error_message),
                notFoundErrorMessage = context.getString(R.string.not_found_error_message),
                notAuthenticatedErrorMessage = context.getString(R.string.not_authenticated_error_message),
                permissionDeniedErrorMessage = context.getString(R.string.permission_denied_error_message),
                noInternetErrorMessage = context.getString(R.string.no_internet_error_message),
                unknownErrorMessage = context.getString(R.string.unknown_error_message)
            )
            return ErrorHandler(errors)
        }

        /**
         * this function provide DataStore<Preferences>
         */

        @Singleton
        @Provides
        fun providePreferenceDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
            return PreferenceDataStoreFactory.create(
                corruptionHandler = ReplaceFileCorruptionHandler(
                    produceNewData = { emptyPreferences() }
                ),
                produceFile = { context.preferencesDataStoreFile(UserPreferences) }
            )
        }
    }

}
