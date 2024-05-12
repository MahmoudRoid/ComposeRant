package parniyan.mahmoudroid.compose.base.presentation.ui.theme.foundation

import androidx.compose.runtime.Stable

import androidx.compose.ui.graphics.Color


/**
 ** Created by Parniyan on 5/10/2024.
 **
 */
@Stable

class Colors(

    val gray: Gray,

    val primary: Primary,

    val caution: Caution,

    val warning: Warning,

    val success: Success,

    val error: Error,

    val purple: Purple,

    val pink: Pink,

    val background: Background,

    val black: Black,

    val white: White,

    val yellow: Yellow
) {

    class Background(val t00: Color)

    class Gray(

        val t0: Color,

        val t1: Color,

        val t2: Color,

        val t3: Color,

        val t4: Color,

        val t5: Color,

        val t6: Color,

        val t7: Color,

        val t8: Color,

        val t9: Color

    )

    class Primary(

        val t0: Color,

        val t1: Color,

        val t2: Color,

        val t3: Color,

        val t4: Color,

        val t5: Color,

        val t6: Color,

        val t7: Color,

        val t8: Color,

        val t9: Color

    )

    class Caution(

        val t0: Color,

        val t1: Color,

        val t2: Color,

        val t3: Color,

        val t4: Color,

        val t5: Color,

        val t6: Color,

        val t7: Color,

        val t8: Color,

        val t9: Color

    )

    class Warning(

        val t0: Color,

        val t1: Color,

        val t2: Color,

        val t3: Color,

        val t4: Color,

        val t5: Color,

        val t6: Color,

        val t7: Color,

        val t8: Color,

        val t9: Color

    )

    class Success(

        val t0: Color,

        val t1: Color,

        val t2: Color,

        val t3: Color,

        val t4: Color,

        val t5: Color,

        val t6: Color,

        val t7: Color,

        val t8: Color,

        val t9: Color

    )

    class Error(

        val t0: Color,

        val t1: Color,

        val t2: Color,

        val t3: Color,

        val t4: Color,

        val t5: Color,

        val t6: Color,

        val t7: Color,

        val t8: Color,

        val t9: Color

    )

    class Purple(

        val t0: Color,

        val t1: Color,

        val t2: Color,

        val t3: Color,

        val t4: Color,

        val t5: Color,

        val t6: Color,

        val t7: Color,

        val t8: Color,

        val t9: Color

    )

    class Pink(

        val t0: Color,

        val t1: Color,

        val t2: Color,

        val t3: Color,

        val t4: Color,

        val t5: Color,

        val t6: Color,

        val t7: Color,

        val t8: Color,

        val t9: Color

    )

    class Black(
        val t00: Color
    )
    class White(
        val t00: Color
    )
    class Yellow(
        val t1: Color,
        val t5: Color
    )

}