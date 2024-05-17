package parniyan.mahmoudroid.compose.network.data

import android.content.Context
import io.ktor.http.*
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */
class LanguageInterceptor(
    context: Context
) : Interceptor {

    private val locale: Locale

    init {
        locale = context.resources.configuration.locales.get(0)
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return chain.proceed(
            request.newBuilder()
                .addHeader(HttpHeaders.AcceptLanguage, locale.language)
                .build()
        )
    }
}