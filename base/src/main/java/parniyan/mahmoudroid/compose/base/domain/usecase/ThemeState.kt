package parniyan.mahmoudroid.compose.base.domain.usecase

import parniyan.mahmoudroid.compose.base.domain.error.ErrorHandler
import parniyan.mahmoudroid.compose.base.domain.repository.BaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import parniyan.mahmoudroid.compose.base.domain.model.ThemeState
import parniyan.mahmoudroid.compose.base.domain.usecase.FlowUseCase
import javax.inject.Inject
import parniyan.mahmoudroid.compose.base.domain.model.ThemeState as ThemeStateModel


/**
 ** Created by Parniyan on 5/10/2024.
 **
 */


class ThemeState @Inject constructor(
    errorHandler: ErrorHandler,
    private val baseRepository: BaseRepository
) : FlowUseCase<Unit, ThemeStateModel>(errorHandler) {
    override fun execute(param: Unit): Flow<ThemeStateModel> {
        return baseRepository.darkTheme().map { ThemeState.getThemeState(it ?: false) }
    }

}