package parniyan.mahmoudroid.compose.base.domain.usecase

import parniyan.mahmoudroid.compose.base.domain.error.ErrorHandler
import parniyan.mahmoudroid.compose.base.domain.model.ThemeState
import parniyan.mahmoudroid.compose.base.domain.repository.BaseRepository
import javax.inject.Inject

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */


class SetThemeState @Inject constructor(
    errorHandler: ErrorHandler,
    private val baseRepository: BaseRepository
) : UseCase<ThemeState, Unit>(errorHandler) {
    override suspend fun execute(param: ThemeState) {
        baseRepository.setThemeState(param)
    }

}