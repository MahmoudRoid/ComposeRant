package parniyan.mahmoudroid.compose.base.domain.error

import com.google.gson.annotations.SerializedName

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

/**
 * Base error model
 * it used when http result is not in (200 - 299)
 */
data class BaseErrorModel(
    @SerializedName("req_id")
    val reqId: String?,
    @SerializedName("error_id")
    val errorId: String?,
    val message: String?,
    val error: ErrorDetail?,
    val details: Any?
)

data class ErrorDetail(val message: String?, val status: String?)
