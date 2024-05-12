package parniyan.mahmoudroid.compose.base.presentation.ext


import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.PopUpToBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import parniyan.mahmoudroid.compose.base.presentation.AppScreen
import parniyan.mahmoudroid.compose.base.presentation.Arg

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

/**
 * Creates composable screen
 *
 * @param screen screen to render
 * @param content content of the screen. it also provides [NavBackStackEntry]
 */
const val NotDefined = "NotDefined"
fun NavGraphBuilder.composable(
    screen: AppScreen.Screen,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route = screen.getRoute(),
        arguments = screen.args.map { navArgument(it.key) { type = it.type } },
        content = content
    )
}


/**
 * Creates composable screen with deeplink
 *
 * @param screen screen to render
 * @param deepLinkUriList deeplink uri patterns
 * @param content content of the screen. it also provides [NavBackStackEntry]
 */
fun NavGraphBuilder.composable(
    screen: AppScreen.Screen,
    deepLinkUriList: List<String>,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route = screen.getRoute(),
        arguments = screen.args.map { navArgument(it.key) { type = it.type } },
        deepLinks = deepLinkUriList.map { navDeepLink { uriPattern = it } },
        content = content
    )
}

/**
 * Creates composable dialog
 *
 * @param dialog dialog to render
 * @param content content of the dialog. it also provides [NavBackStackEntry]
 */
fun NavGraphBuilder.dialog(
    dialog: AppScreen.Dialog,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    dialog(
        route = dialog.getRoute(),
        arguments = dialog.args.map { navArgument(it.key) { type = it.type } },
        content = content
    )
}


/**
 * Creates composable bottom sheet
 *
 * @param bottomSheet bottom sheet to render
 * @param content content of the bottom sheet. it also provides [NavBackStackEntry]
 */
@OptIn(ExperimentalMaterialNavigationApi::class)
/*fun NavGraphBuilder.bottomSheet(
    bottomSheet: AppScreen.BottomSheet,
    content: @Composable ColumnScope.(NavBackStackEntry) -> Unit
) {
    bottomSheet(
        route = bottomSheet.getRoute(),
        arguments = bottomSheet.args.map { navArgument(it.key) { type = it.type } },
        content = content
    )
}*/


/**
 * Sets data in order to send result to previous page.
 * it can be observed by [observeData].
 *
 * @param key value key
 * @param value result value
 */
fun <T> NavController.setData(key: String, value: T) {
    previousBackStackEntry?.savedStateHandle?.set(key, value)
}

/**
 * Observes the data in current [NavBackStackEntry].
 * the data can be set in different ways. it can be used to wait for result of the next page.
 * the next page result can be set by [setData].
 *
 * @param key value key
 * @return result value
 */
fun <T> NavController.observeData(key: String): LiveData<T>? {
    return currentBackStackEntry?.savedStateHandle?.getLiveData(key)
}

/**
 * Navigates to screen
 *
 * @param screen screen to navigate
 * @param args screen arguments
 */
fun NavController.navigate(screen: AppScreen.Screen, vararg args: Any?) {
    navigate(route = screen.name.addArgs(args, screen.args))
}

/**
 * Navigates to screen
 *
 * @param screen screen to navigate
 * @param args screen arguments
 * @param builder nav option builder
 */
fun NavController.navigate(
    screen: AppScreen.Screen,
    vararg args: Any?,
    builder: NavOptionsBuilder.() -> Unit
) {
    navigate(route = screen.name.addArgs(args, screen.args), builder = builder)
}

/**
 * Navigates to screen
 *
 * @param screen screen to navigate
 * @param builder nav option builder
 */
fun NavController.navigate(screen: AppScreen.Screen, builder: NavOptionsBuilder.() -> Unit) {
    navigate(route = screen.name.addDefaultArgs(screen.args), builder = builder)
}

/**
 * Pop up to a given destination before navigating. This pops all non-matching destination routes
 * from the back stack until the destination with a matching route is found.
 * this method only works on screens with no argument.
 *
 * @param screen route for the destination
 * @param popUpToBuilder builder used to construct a popUpTo operation
 */
fun NavOptionsBuilder.popUpTo(
    screen: AppScreen.Screen,
    popUpToBuilder: PopUpToBuilder.() -> Unit = {}
) {
    popUpTo(route = screen.name.addDefaultArgs(screen.args), popUpToBuilder)
}

/**
 * Navigates to dialog
 *
 * @param dialog dialog to navigate
 * @param args dialog arguments
 */
fun NavController.navigate(dialog: AppScreen.Dialog, vararg args: Any?) {
    navigate(route = dialog.name.addArgs(args, dialog.args))
}

/**
 * Navigates to bottom sheet
 *
 * @param bottomSheet bottom sheet to navigate
 * @param args bottom sheet arguments
 */
fun NavController.navigate(bottomSheet: AppScreen.BottomSheet, vararg args: Any?) {
    navigate(route = bottomSheet.name.addArgs(args, bottomSheet.args))
}


/**
 * Creates a default argument just to make destination route
 */
private fun String.addDefaultArgs(defaultArgs: Array<out Arg<*>>): String =
    addArgs(arrayOf(), defaultArgs)

/**
 * Gets screen route with args
 * */
private fun AppScreen.Screen.getRoute(): String =
    StringBuilder(name).apply { args.forEach { append("/{${it.key}}") } }.toString()

/**
 * Gets dialog route with args
 * */
private fun AppScreen.Dialog.getRoute(): String =
    StringBuilder(name).apply { args.forEach { append("/{${it.key}}") } }.toString()

/**
 * Gets dialog route with args
 * */
private fun AppScreen.BottomSheet.getRoute(): String =
    StringBuilder(name).apply { args.forEach { append("/{${it.key}}") } }.toString()


/**
 * Adds arguments to given screen destination.
 * it will fill arguments with default value if they where not provided in navigation.
 * this methods only works when args provided in order otherwise destination won't be found and
 * [androidx.navigation] will throw exception.
 * */
private fun String.addArgs(args: Array<out Any?>, defaultArgs: Array<out Arg<*>>): String {
    val arguments = arrayOfNulls<Any>(defaultArgs.size)
    defaultArgs.forEachIndexed { index, arg ->
        arguments[index] =
            if (index < args.size) args[index] ?: arg.defaultValue!! else arg.defaultValue!!
    }
    return StringBuilder(this).apply { arguments.forEach { append("/$it") } }.toString()
}

fun String.isDefined() = this != NotDefined