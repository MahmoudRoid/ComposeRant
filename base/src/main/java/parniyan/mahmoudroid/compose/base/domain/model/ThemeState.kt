package parniyan.mahmoudroid.compose.base.domain.model

/**
 *Created by parniyan on 12/11/23.
 */


sealed class ThemeState(var isDark: Boolean) {

    data object Dark : ThemeState(true)
    data object Light : ThemeState(false)

    companion object {
        fun getThemeState(isDark: Boolean) = when (isDark) {
            Dark.isDark -> Dark
            Light.isDark -> Light
            else -> {
                Light
            }
        }
    }
}