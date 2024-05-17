package parniyan.mahmoudroid.compose.network.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import parniyan.mahmoudroid.compose.network.di.GeneralHttpClient
import parniyan.mahmoudroid.compose.network.domain.repository.NetworkRepository
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */
class NetworkRepositoryImpl @Inject constructor(

    @GeneralHttpClient
    private val client: HttpClient,
    private val dataStore: DataStore<Preferences>
) : NetworkRepository {


    override suspend fun setIntegrationHeaderPresence(presence: Boolean) {
        dataStore.edit {
            it[NetworkRepository.IntegrationHeaderPresenceKey] = presence
        }
    }

    override suspend fun getIntegrationHeaderPresence(): Boolean {
        return dataStore.data.map {
            it[NetworkRepository.IntegrationHeaderPresenceKey]
        }.firstOrNull() ?: false
    }
}