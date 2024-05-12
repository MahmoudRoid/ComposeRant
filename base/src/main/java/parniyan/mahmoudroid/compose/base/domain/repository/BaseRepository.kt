package parniyan.mahmoudroid.compose.base.domain.repository

import androidx.datastore.preferences.core.booleanPreferencesKey
import parniyan.mahmoudroid.compose.base.domain.model.ThemeState
import kotlinx.coroutines.flow.Flow

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */
interface BaseRepository {

    fun getAppVersionName(): String


    suspend fun setThemeState(themeState: ThemeState)

    /**
     * Returns if dark theme is enabled
     */
    fun darkTheme(): Flow<Boolean?>


    companion object {
        internal val DarkThemePreferencesKey = booleanPreferencesKey("is_dark_theme")
    }
}