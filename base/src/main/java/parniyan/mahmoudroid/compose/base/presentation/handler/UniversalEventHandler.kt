package parniyan.mahmoudroid.compose.base.presentation.handler

import parniyan.mahmoudroid.compose.base.domain.event.Event
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import parniyan.mahmoudroid.compose.base.presentation.handler.UniversalEvent

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */
class UniversalEventHandler {
    private val _universalEventBus = MutableSharedFlow<UniversalEvent>(replay = 1)
    val universalEventBus: SharedFlow<UniversalEvent> = _universalEventBus.asSharedFlow()

    fun sendEvent(name: String) {
        _universalEventBus.tryEmit(
            UniversalEvent(
                name = name,
                event = Event(Unit)
            )
        )
    }
}