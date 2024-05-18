package parniyan.mahmoudroid.compose

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */
@HiltAndroidApp
class App : Application(), AppLifecycleListener, Configuration.Provider {


    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()

    override fun onAppOpen() {
        TODO("Not yet implemented")
    }

    override fun onAppClose() {
        TODO("Not yet implemented")
    }

}