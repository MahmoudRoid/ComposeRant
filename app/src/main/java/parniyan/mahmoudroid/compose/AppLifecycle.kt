package parniyan.mahmoudroid.compose

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */
class AppLifecycle(
    private val appLifecycleListener: AppLifecycleListener
) : Application.ActivityLifecycleCallbacks {
    private val activities = mutableListOf<String>()

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        //do nothing
    }

    override fun onActivityStarted(activity: Activity) {
        if (activities.isEmpty()) appLifecycleListener.onAppOpen()
        activities.add(activity.localClassName)
    }

    override fun onActivityResumed(activity: Activity) {
        //do nothing
    }

    override fun onActivityPaused(activity: Activity) {
        //do nothing
    }

    override fun onActivityStopped(activity: Activity) {
        activities.remove(activity.localClassName)
        if (activities.isEmpty()) appLifecycleListener.onAppClose()
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        //do nothing
    }

    override fun onActivityDestroyed(activity: Activity) {
        //do nothing
    }
}