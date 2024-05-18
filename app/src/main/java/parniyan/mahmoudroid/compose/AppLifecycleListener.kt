package parniyan.mahmoudroid.compose

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */
interface AppLifecycleListener {

    /**
     * Invokes when application start with at least one activity
     */
    fun onAppOpen()

    /**
     * Invokes when last activity stops and no activity is on foreground
     * Note: App might be available in android OS recent apps
     */
    fun onAppClose()
}