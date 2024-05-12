package parniyan.mahmoudroid.compose.base.presentation

import androidx.annotation.StringRes
import androidx.lifecycle.*
import parniyan.mahmoudroid.compose.base.domain.event.Event
import parniyan.mahmoudroid.compose.base.domain.usecase.UseCase
import parniyan.mahmoudroid.compose.base.domain.usecase.FlowUseCase
import kotlinx.coroutines.flow.Flow
import parniyan.mahmoudroid.compose.base.domain.error.Error

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

/**
 * Base view model that can handle error message and progress.
 * it also can handle use cases.
 *
 * @see [UseCase]
 * @see [FlowUseCase]
 */
abstract class BaseViewModel : ViewModel() {
    /**
     * Message string resource id for events
     */
    val messageStringId: MutableLiveData<Event<Int>> = MutableLiveData()

    /**
     * Message for events
     */
    val message: MutableLiveData<Event<String>> = MutableLiveData()

    /**
     * Indicates loading if it sets on usecases
     */
    val progress: MutableLiveData<Boolean> = MutableLiveData()

    /**
     * Sets event message
     */
    protected fun setMessage(message: String) {
        this.message.value = Event(message)
    }

    /**
     * Sets event message string resource id
     */
    protected fun setMessageStringId(@StringRes id: Int) {
        this.messageStringId.value = Event(id)
    }

    /**
     * Invokes usecase and uses [viewModelScope] for background process
     */
    protected operator fun <Param, Type> UseCase<Param, Type>.invoke(
        param: Param,
        progress: Boolean = true,
        onCancel: (() -> Unit)? = null,
        onError: ((Error) -> Unit)? = null,
        onResult: ((Type) -> Unit)? = null,
    ): UseCase<Param, Type> {
        return this(
            param = param,
            progress = progress,
            onCancel = onCancel,
            onError = onError,
            onResult = onResult,
            backgroundContext = viewModelScope.coroutineContext
        )
    }

    /**
     * Adds error handler ability to usecase. It can be read by observing [message]
     */
    protected fun UseCase<*, *>.onError(): UseCase<*, *> {
        onErrorMessage { errorMessage ->
            errorMessage.let { message.value = Event(it) }
        }
        return this
    }

    /**
     * Adds loading indication ability to usecase. It can be read by observing [progress]
     */
    protected fun UseCase<*, *>.onProgress(): UseCase<*, *> {
        onProgressChanged {
            progress.value = it
        }
        return this
    }

    /**
     * Invokes usecase and sends the result as live date
     *
     * @param handleProgress handles loading
     * @param handleError handles error
     * @param onError provides error message
     */
    protected fun <T> UseCase<*, T>.toLiveData(
        handleProgress: Boolean = false,
        handleError: Boolean = true,
        onError: ((Error) -> Unit)? = null
    ): LiveData<T> {
        return toMutableLiveData(
            handleProgress = handleProgress,
            handleError = handleError,
            onError = onError
        )
    }

    /**
     * Invokes usecase and sends the result as mutable live date
     *
     * @param handleProgress handles loading
     * @param handleError handles error
     * @param onError provides error message
     */
    protected fun <T> UseCase<*, T>.toMutableLiveData(
        handleProgress: Boolean = false,
        handleError: Boolean = true,
        onError: ((Error) -> Unit)? = null
    ): MutableLiveData<T> {
        val liveData = MutableLiveData<T>()
        onResult {
            liveData.value = it
        }
        onError?.let { this.onError(it) }
        if (handleProgress) onProgress()
        if (handleError) onError()
        return liveData
    }

    /**
     * Creates a LiveData that has values collected from the origin [Flow] in [viewModelScope]
     */
    /*protected fun <T> Flow<T>.toLiveData(): LiveData<T> {
        return asLiveData(viewModelScope.coroutineContext)
    }*/

    /**
     * Makes live data list value to mutable list
     */
    protected fun <T> LiveData<List<T>>.toMutableList() = map { it.toMutableList() }
}
