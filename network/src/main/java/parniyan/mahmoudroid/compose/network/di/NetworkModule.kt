package parniyan.mahmoudroid.compose.network.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import parniyan.mahmoudroid.compose.network.domain.repository.NetworkRepository
import io.ktor.client.HttpClient
import parniyan.mahmoudroid.compose.base.data.network.NetworkFactory
import parniyan.mahmoudroid.compose.network.data.LanguageInterceptor
import parniyan.mahmoudroid.compose.network.data.remote.interceptor.IntegrationHeaderInterceptor
import parniyan.mahmoudroid.compose.network.data.repository.NetworkRepositoryImpl
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */
/**
 * this class is contain hilt needed bindings and provides
 */
@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkRepository(
        @GeneralHttpClient
        client: HttpClient,
        dataStore: DataStore<Preferences>
    ): NetworkRepository {
        return NetworkRepositoryImpl(
            client = client,
            dataStore = dataStore
        )
    }

    @Singleton
    @Provides
    fun provideIntegrationHeaderInterceptor(networkRepository: NetworkRepository): IntegrationHeaderInterceptor {
        return IntegrationHeaderInterceptor(networkRepository)
    }

    @Singleton
    @Provides
    fun provideChuckerInterceptor(@ApplicationContext context: Context): ChuckerInterceptor {
        return ChuckerInterceptor.Builder(context)
            .alwaysReadResponseBody(true)
            .build()
    }

    @Singleton
    @Provides
    fun provideLanguageInterceptor(@ApplicationContext context: Context): LanguageInterceptor {
        return LanguageInterceptor(context)
    }

    /**
     * this function provide NetworkFactory
     */
    @Singleton
    @Provides
    fun provideNetworkFactory(
        chuckerInterceptor: ChuckerInterceptor,
        languageInterceptor: LanguageInterceptor,
        integrationHeaderInterceptor: IntegrationHeaderInterceptor
    ): NetworkFactory {
        return NetworkFactory(
            baseUrl = "BASE_URL",
            interceptors = listOf(
                chuckerInterceptor,
                languageInterceptor,
                integrationHeaderInterceptor
            )
        )
    }

    /**
     * Provides network factory with no credentials
     * Suitable for downloads
     */
    @GeneralNetworkFactory
    @Singleton
    @Provides
    fun provideGeneralNetworkFactory(
        chuckerInterceptor: ChuckerInterceptor
    ): NetworkFactory {
        return NetworkFactory(interceptors = listOf(chuckerInterceptor))
    }

    /**
     * Provides HttpClient with credentials
     */
    @Singleton
    @Provides
    fun provideHttpClient(networkFactory: NetworkFactory): HttpClient {
        return networkFactory.client
    }

    /**
     * Provides general HttpClient
     */
    @GeneralHttpClient
    @Singleton
    @Provides
    fun provideGeneralHttpClient(@GeneralNetworkFactory networkFactory: NetworkFactory): HttpClient {
        return networkFactory.client
    }


}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class GeneralNetworkFactory

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class GeneralHttpClient

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class UploadOkHttpClient

