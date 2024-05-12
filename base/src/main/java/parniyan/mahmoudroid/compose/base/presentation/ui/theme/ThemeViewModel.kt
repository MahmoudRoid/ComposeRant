package parniyan.mahmoudroid.compose.base.presentation.ui.theme

import dagger.hilt.android.lifecycle.HiltViewModel
import parniyan.mahmoudroid.compose.base.domain.usecase.interactor.BaseInteractor
import parniyan.mahmoudroid.compose.base.presentation.BaseViewModel
import javax.inject.Inject


/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val baseInteractor: BaseInteractor
) : BaseViewModel() {

    val isDarkTheme = baseInteractor.themeState(Unit)
}