package parniyan.mahmoudroid.compose.base.domain.usecase

import parniyan.mahmoudroid.compose.base.domain.error.Error
import parniyan.mahmoudroid.compose.base.domain.error.ErrorHandler
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

/**
 *  use case that handles error and returns result
 *
 * @param errorHandler used to handle different errors
 * @param foregroundContext coroutineContext to get result
 */
abstract class UseCase<Param, Type>(
    private val errorHandler: ErrorHandler,
    private val foregroundContext: CoroutineContext = Dispatchers.Main
) {
    private var job = Job()
    private var onErrorMessage: ((String) -> Unit)? = null
    private var onProgress: ((Boolean) -> Unit)? = null
    private var onResult: ((Type) -> Unit)? = null
    private var onError: ((Error) -> Unit)? = null

    /**
     * operator invoke function to run this use case
     */
    operator fun invoke(
        param: Param,
        progress: Boolean = true,
        onCancel: (() -> Unit)? = null,
        onError: ((Error) -> Unit)? = null,
        onResult: ((Type) -> Unit)? = null,
        backgroundContext: CoroutineContext
    ): UseCase<Param, Type> {
        cancel()
        job = Job()
        CoroutineScope(foregroundContext + job).launch {
            try {
                if (progress) onProgress?.invoke(true)
                val result = withContext(backgroundContext) { execute(param) }
                onResult?.invoke(result)
                this@UseCase.onResult?.invoke(result)
                if (progress) onProgress?.invoke(false)
            } catch (cancellationException: CancellationException) {
                if (progress) onProgress?.invoke(false)
                onCancel?.invoke()
            } catch (e: Exception) {
                if (progress) onProgress?.invoke(false)

                val error = errorHandler.getError(e)
                onError?.invoke(error)
                this@UseCase.onError?.invoke(error)
                onErrorMessage?.invoke(error.errorMessage)
            }
        }
        return this
    }

    /**
     * runs this use case
     */
    abstract suspend fun execute(param: Param): Type

    /**
     * lambda that provides error message
     */
    fun onErrorMessage(block: (String) -> Unit) {
        onErrorMessage = block
    }

    /**
     * lambda that provides progress
     */
    fun onProgressChanged(block: (Boolean) -> Unit) {
        onProgress = block
    }

    /**
     * lambda that provides result
     */
    fun onResult(block: (Type) -> Unit) {
        onResult = block
    }

    /**
     * lambda that provides error
     */
    fun onError(block: (Error) -> Unit) {
        onError = block
    }

    /**
     * stops this use case
     */
    fun cancel() {
        job.apply {
            cancelChildren()
            cancel()
        }
    }
}