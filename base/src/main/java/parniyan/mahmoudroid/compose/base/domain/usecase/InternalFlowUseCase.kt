package parniyan.mahmoudroid.compose.base.domain.usecase

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

/**
 * An internal flow use case that must be used in cases that we are sure no error will happen.
 * in case of error a simple log will be printed.
 */
abstract class InternalFlowUseCase<Param, Type> {

    operator fun invoke(param: Param): Flow<Type> {
        return execute(param)
            .catch {
                Log.e("ComposeRantDebug", "message -> ${it.message}")
            }
    }

    /**
     * runs this use case
     * */
    abstract fun execute(param: Param): Flow<Type>
}
