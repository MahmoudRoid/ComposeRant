package parniyan.mahmoudroid.compose.base.domain.error

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

/**
 * Log prefix
 */
private const val LogPrefix = "ComposeRantError"

/**
 * This is a base error that all exceptions will be mapped to this object.
 *
 * @param code custom error code from [Errors]
 * @param errorMessage custom error message from [Errors]
 */
class Error(val code: Int, val errorMessage: String) :
    Throwable("$LogPrefix: code-> $code , message-> $errorMessage")