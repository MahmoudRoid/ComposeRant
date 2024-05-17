package parniyan.mahmoudroid.compose.network.data.remote.interceptor

import parniyan.mahmoudroid.compose.network.domain.repository.NetworkRepository
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */
class IntegrationHeaderInterceptor(
    private val networkRepository: NetworkRepository
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().apply {
            if (runBlocking { networkRepository.getIntegrationHeaderPresence() }) {
                addHeader("integration", "true")
            }
        }.build()

        return chain.proceed(request)
    }
}