package parniyan.mahmoudroid.compose.base.presentation.ui.theme.foundation

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

@Immutable
class Typography (
    val regular: Regular,
    val medium: Medium,
    val bold: Bold
) {

    class Regular(
        val h1: TextStyle,
        val h2: TextStyle,
        val h3: TextStyle,
        val title1: TextStyle,
        val title2: TextStyle,
        val body1: TextStyle,
        val body2: TextStyle,
        val caption1: TextStyle,
        val caption2: TextStyle
    )

    class Medium(
        val title2: TextStyle,
        val body1: TextStyle,
        val body2: TextStyle,
        val caption1: TextStyle
    )

    class Bold(
        val h1: TextStyle,
        val h2: TextStyle,
        val h3: TextStyle,
        val title1: TextStyle,
        val title2: TextStyle,
        val body1: TextStyle,
        val body2: TextStyle,
        val caption1: TextStyle,
        val caption2: TextStyle
    )

}
