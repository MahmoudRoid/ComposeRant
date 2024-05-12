package parniyan.mahmoudroid.compose.base.domain.util

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

/**
 * Ktor version annotation
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@MustBeDocumented
@RequiresOptIn(
    message = "This method must be used carefully. it may not work after ktor library version changed.",
    RequiresOptIn.Level.WARNING
)
annotation class KtorException()
