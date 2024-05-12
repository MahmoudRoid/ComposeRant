package parniyan.mahmoudroid.compose.base.presentation.handler

import parniyan.mahmoudroid.compose.base.domain.event.Event


/**
 ** Created by Parniyan on 5/10/2024.
 **
 */
class UniversalEvent(
    val name: String,
    val event: Event<Unit>
)

class UniversalEventWithData(
    val name: String,
    val event: Event<String>
)