package parniyan.mahmoudroid.compose.base.data.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

/**
 * Executes a [HttpClient] GET request, with the specified [path].
 * an optional [block] receiving an [HttpRequestBuilder] for further configuring the request.
 */
suspend inline fun <reified T> HttpClient.get(
    path: String,
    crossinline block: HttpRequestBuilder.() -> Unit = {}
): T =
    get { url { path(path); contentType(ContentType.Application.Json); block() } }.body()

/**
 * Executes a [HttpClient] POST request, with the specified [path].
 * an optional [block] receiving an [HttpRequestBuilder] for further configuring the request.
 */
suspend inline fun <reified T> HttpClient.post(
    path: String,
    crossinline block: HttpRequestBuilder.() -> Unit = {}
): T =
    post { url { path(path); contentType(ContentType.Application.Json); block() } }.body()

/**
 * Executes a [HttpClient] PUT request, with the specified [path].
 * an optional [block] receiving an [HttpRequestBuilder] for further configuring the request.
 */
suspend inline fun <reified T> HttpClient.put(
    path: String,
    crossinline block: HttpRequestBuilder.() -> Unit = {}
): T =
    put { url { path(path); contentType(ContentType.Application.Json); block() } }.body()

/**
 * Executes a [HttpClient] DELETE request, with the specified [path].
 * an optional [block] receiving an [HttpRequestBuilder] for further configuring the request.
 */
suspend inline fun <reified T> HttpClient.delete(
    path: String,
    crossinline block: HttpRequestBuilder.() -> Unit = {}
): T =
    delete { url { path(path); contentType(ContentType.Application.Json); block() } }.body()

suspend inline fun <reified T> HttpClient.patch(
    path: String,
    crossinline block: HttpRequestBuilder.() -> Unit = {}
): T =
    patch { url { path(path); contentType(ContentType.Application.Json); block() } }.body()

