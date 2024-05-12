package parniyan.mahmoudroid.compose.base.data.network

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.gson.*
import okhttp3.Interceptor
import okhttp3.Protocol

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

/**
 * Provides network client for http requests.
 *
 * @param baseUrl base url for http request
 * @param interceptors list of http interceptor
 *
 * @see [AuthInterceptor]
 * */

const val NetworkTimeOut = 30000L

class NetworkFactory(
    private val baseUrl: String? = null,
    private val interceptors: List<Interceptor> = listOf(),
    private val protocols: List<Protocol> = listOf(),
    private val timeoutMillis: Long = NetworkTimeOut
) {

    val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            gson {
                setPrettyPrinting()
            }
        }

        expectSuccess = true

        install(HttpTimeout) {
            requestTimeoutMillis = NetworkTimeOut
            connectTimeoutMillis = NetworkTimeOut
            socketTimeoutMillis = NetworkTimeOut
        }

        engine {
            interceptors.forEach { addInterceptor(it) }
            config {
                retryOnConnectionFailure(true)
                if (protocols.isNotEmpty()) {
                    protocols(protocols)
                }
            }
        }

        install(Logging) {
            level = LogLevel.ALL
        }

        defaultRequest {
            baseUrl?.let { url(it) }
        }
    }
}
