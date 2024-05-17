package parniyan.mahmoudroid.compose.network.domain.repository

import androidx.datastore.preferences.core.booleanPreferencesKey

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */
interface NetworkRepository {

    suspend fun setIntegrationHeaderPresence(presence: Boolean)
    suspend fun getIntegrationHeaderPresence(): Boolean

    companion object {
        internal val IntegrationHeaderPresenceKey =
            booleanPreferencesKey("integration_header_presence")
    }
}