package parniyan.mahmoudroid.compose.base.data.repository

import android.content.Context
import android.content.pm.PackageManager
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import parniyan.mahmoudroid.compose.base.domain.model.ThemeState
import parniyan.mahmoudroid.compose.base.domain.repository.BaseRepository
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

class BaseRepositoryImpl @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val client: HttpClient,
    private val dataStore: DataStore<Preferences>,
) : BaseRepository {

    override fun getAppVersionName(): String {
        return try {
            val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            packageInfo.versionName ?: ""
        } catch (e: PackageManager.NameNotFoundException) {
            ""
        }
    }

    override fun darkTheme(): Flow<Boolean> {
        val nightModeFlags =
            context.resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK
        val darkTheme = nightModeFlags == android.content.res.Configuration.UI_MODE_NIGHT_YES
        return dataStore.data.map {
            it[BaseRepository.DarkThemePreferencesKey] ?: darkTheme
        }
    }

    override suspend fun setThemeState(themeState: ThemeState) {
        dataStore.edit {
            themeState.isDark?.run {
                it[BaseRepository.DarkThemePreferencesKey] = themeState.isDark
            }
        }
    }

}
