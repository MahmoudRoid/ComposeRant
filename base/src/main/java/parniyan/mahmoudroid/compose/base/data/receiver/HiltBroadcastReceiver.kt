package parniyan.mahmoudroid.compose.base.data.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

/**
 * This allow us to inject object in broadcast receivers
 */
abstract class HiltBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        //do nothing
        //just injections happens here
    }
}