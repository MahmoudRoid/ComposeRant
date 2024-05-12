package parniyan.mahmoudroid.compose.base.domain.error

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import parniyan.mahmoudroid.compose.base.domain.usecase.UseCase
import parniyan.mahmoudroid.compose.base.domain.util.KtorException
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ResponseException
import java.io.IOException

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

/**
 * Handles [UseCase]'s error
 * it will generate error if it is not handled
 *
 * @param errors error handler class for multi language
 */
class ErrorHandler(
    private val errors: Errors = Errors.Default
) {
    val gson: Gson = GsonBuilder().create()

    /**
     * Gets mapped [Error]
     */
    @OptIn(KtorException::class)
    fun getError(exception: Exception): Error =
        when (exception) {
            // TODO: Fix this after finding a way to separate network error from IO error in ktor
            is IOException -> Error(IOErrorCode, errors.networkErrorMessage)
           is ResponseException -> when (exception.response.status.value) {
             /*    in HttpStatusCode.InternalServerError.value..HttpStatusCode.GatewayTimeout.value -> Error(
                    ServerErrorCode, errors.serverErrorMessage
                )*/

                else -> {
                    val error = getErrorMessageFromException(exception)
                    if (!error?.error?.message.isNullOrEmpty()) {
                        Error(exception.response.status.value, error?.error?.message!!)
                    } else {
                        Error(NetworkErrorCode, errors.networkErrorMessage)
                    }
                }
            }

            else -> Error(UnknownErrorCode, errors.networkErrorMessage)
        }

    /**
     * This functions substrings the error body from custom error message
     * @see [ClientRequestException]
     *
     * this method is not the best solution to get error body.
     *
     */

    private fun getErrorMessageFromException(exception: ResponseException): BaseErrorModel? {
        return runCatching {
            val message = exception.message?.substringAfterLast("Text: ")
                ?.removePrefix("\"")
                ?.removeSuffix("\"")
            gson.fromJson(message, BaseErrorModel::class.java)
        }.getOrNull()
    }
}