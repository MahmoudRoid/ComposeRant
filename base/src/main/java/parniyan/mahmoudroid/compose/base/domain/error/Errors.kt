package parniyan.mahmoudroid.compose.base.domain.error

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

const val IOErrorCode = 700
const val NetworkErrorCode = 701
const val ServerErrorCode = 702
const val NotFoundErrorCode = 703
const val NotAuthenticatedErrorCode = 704
const val PermissionDeniedErrorCode = 705
const val NoInternetErrorCode = 706
const val UnknownErrorCode = 707

private const val DefaultIOErrorMessage = "Error!"
private const val DefaultNetworkErrorMessage = "Connection Error!"
private const val DefaultServerErrorMessage = "Server Error!"
private const val DefaultNotFoundErrorMessage = "Not Found!"
private const val DefaultNotAuthenticatedErrorMessage = "Not Authenticated"
private const val DefaultPermissionDeniedErrorMessage = "Permission Denied!"
private const val DefaultNoInternetErrorMessage = "Make sure you are connected to the internet"
private const val DefaultUnknownErrorMessage = "Unknown Error!"

/**
 * Defines common error messages.
 * @see [ErrorHandler]
 */
class Errors(
    val ioErrorMessage: String = DefaultIOErrorMessage,
    val networkErrorMessage: String = DefaultNetworkErrorMessage,
    val serverErrorMessage: String = DefaultServerErrorMessage,
    val notFoundErrorMessage: String = DefaultNotFoundErrorMessage,
    val notAuthenticatedErrorMessage: String = DefaultNotAuthenticatedErrorMessage,
    val permissionDeniedErrorMessage: String = DefaultPermissionDeniedErrorMessage,
    val noInternetErrorMessage: String = DefaultNoInternetErrorMessage,
    val unknownErrorMessage: String = DefaultUnknownErrorMessage
) {

    companion object {
        val Default = Errors()
    }
}