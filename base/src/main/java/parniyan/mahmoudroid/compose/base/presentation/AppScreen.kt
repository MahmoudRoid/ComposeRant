package parniyan.mahmoudroid.compose.base.presentation

import androidx.navigation.NavType

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

/**
 * The base class to define app screens and dialogs to use with navigation compose
 */
sealed class AppScreen<T> {

    /**
     * Base screen
     *
     * @param name screen name
     * @param args screen arguments
     */
    open class Screen(val name: String, vararg val args: Arg<*>) : AppScreen<Screen>()

    /**
     * Base dialog
     *
     * @param name dialog name
     * @param args dialog arguments
     */
    open class Dialog(val name: String, vararg val args: Arg<*>) : AppScreen<Dialog>()

    /**
     * Base bottom sheet
     *
     * @param name bottom sheet name
     * @param args bottom sheet arguments
     */
    open class BottomSheet(val name: String, vararg val args: Arg<*>) : AppScreen<BottomSheet>()
}

/**
 * Base argument class to provide composeRantargs for jetpack compose navigation
 *
 * @param key param key
 * @param type param type
 * @param defaultValue argument default value if no argument sent in navigation
 */
open class Arg<T>(val key: String, val type: NavType<T>, val defaultValue: T)