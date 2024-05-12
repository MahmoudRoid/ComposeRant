package parniyan.mahmoudroid.compose.base.domain.usecase

import android.util.Log

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

/**
 * An internal suspend use case that must be used in cases that we are sure no error will happen.
 * in case of error a simple log will be printed.
 */
abstract class InternalSuspendUseCase<Param, Type> {

    suspend operator fun invoke(param: Param): Type? {
        return runCatching {
            execute(param)
        }.onFailure {
            Log.e("ComposeRantDebug", "message -> ${it.message}")
        }.getOrNull()
    }

    /**
     * runs this use case
     */
    abstract suspend fun execute(param: Param): Type
}