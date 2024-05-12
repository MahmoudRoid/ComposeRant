package parniyan.mahmoudroid.compose.base.domain.usecase

import parniyan.mahmoudroid.compose.base.domain.error.Error
import parniyan.mahmoudroid.compose.base.domain.error.ErrorHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

/**
 * Flow use case that handles error and emits new value on demand
 *
 * @param errorHandler used to handle different errors
 * @param coroutineContext coroutineContext to flow on
 * */
abstract class FlowUseCase<Param, Type>(
    private val errorHandler: ErrorHandler,
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) {
    private var onErrorMessage: ((String) -> Unit)? = null

    /**
     * operator invoke function to run this use case
     * */
    operator fun invoke(
        param: Param,
        onError: ((Error) -> Unit)? = null
    ): Flow<Type> {
        return execute(param)
            .catch {
                val error = errorHandler.getError(Exception(it))
                onError?.invoke(error)
                onErrorMessage?.invoke(error.errorMessage)
            }
            .flowOn(coroutineContext)
    }

    /**
     * runs this use case
     * */
    abstract fun execute(param: Param): Flow<Type>

    /**
     * lambda that provides error message
     * */
    fun onErrorMessage(block: ((String) -> Unit)) {
        onErrorMessage = block
    }

    /**
     * removes references
     * */
    fun unsubscribe() {
        onErrorMessage = null
    }
}
