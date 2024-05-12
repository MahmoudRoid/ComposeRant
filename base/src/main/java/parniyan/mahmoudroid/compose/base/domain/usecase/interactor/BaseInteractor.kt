package parniyan.mahmoudroid.compose.base.domain.usecase.interactor

import parniyan.mahmoudroid.compose.base.domain.usecase.SetThemeState
import parniyan.mahmoudroid.compose.base.domain.usecase.ThemeState
import javax.inject.Inject

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */
class BaseInteractor @Inject constructor(
    val themeState: ThemeState,
    val setThemeState: SetThemeState
)