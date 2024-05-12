package parniyan.mahmoudroid.compose.base.presentation.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import parniyan.mahmoudroid.compose.base.presentation.ui.theme.foundation.Colors

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

/**
 * Provides all compose rant light and dark colors
 * NOTE: this can only be used to define compose rant theme, DO NOT use it directly
 */
internal object ComposeRantColor {

    val lightColors = Colors(
        gray = Colors.Gray(
            t0 = Color(0xFFF6F8FA),
            t1 = Color(0xFFEAEEF2),
            t2 = Color(0xFFD0D7DE),
            t3 = Color(0xFFAFB8C1),
            t4 = Color(0xFF8C959F),
            t5 = Color(0xFF6E7781),
            t6 = Color(0xFF57606A),
            t7 = Color(0xFF424A53),
            t8 = Color(0xFF32383F),
            t9 = Color(0xFF24292F)
        ),
        primary = Colors.Primary(
            t0 = Color(0xFFE0ECFF),
            t1 = Color(0xFFC0D9FF),
            t2 = Color(0xFF80B3FF),
            t3 = Color(0xFF408CFF),
            t4 = Color(0xFF005CDD),
            t5 = Color(0xFF007AFF),
            t6 = Color(0xFF003988),
            t7 = Color(0xFF002963),
            t8 = Color(0xFF2A2C2E),
            t9 = Color(0xFF001532)
        ),
        caution = Colors.Caution(
            t0 = Color(0xFFFFFADB),
            t1 = Color(0xFFFFF7C8),
            t2 = Color(0xFFFFEF92),
            t3 = Color(0xFFFFE65B),
            t4 = Color(0xFFFFDE24),
            t5 = Color(0xFFFFD800),
            t6 = Color(0xFFDBBA00),
            t7 = Color(0xFFB69B00),
            t8 = Color(0xFF927C00),
            t9 = Color(0xFF5B4D00)
        ),
        warning = Colors.Warning(
            t0 = Color(0xFFFFE7DB),
            t1 = Color(0xFFFFB692),
            t2 = Color(0xFFFF925B),
            t3 = Color(0xFFFF8649),
            t4 = Color(0xFFFF6D24),
            t5 = Color(0xFFFF5400),
            t6 = Color(0xFFDB4900),
            t7 = Color(0xFFB63D00),
            t8 = Color(0xFF802B00),
            t9 = Color(0xFF491800)
        ),
        success = Colors.Success(
            t0 = Color(0xFFEBFDE9),
            t1 = Color(0xFFD6FDD1),
            t2 = Color(0xFFA7F9A7),
            t3 = Color(0xFF78ED84),
            t4 = Color(0xFF54DC6E),
            t5 = Color(0xFF34C85A),
            t6 = Color(0xFF1AAA52),
            t7 = Color(0xFF118D4E),
            t8 = Color(0xFF0B7247),
            t9 = Color(0xFF065F43)
        ),
        error = Colors.Error(
            t0 = Color(0xFFFFEBE9),
            t1 = Color(0xFFFFCECB),
            t2 = Color(0xFFFFABA8),
            t3 = Color(0xFFFF8182),
            t4 = Color(0xFFFA4549),
            t5 = Color(0xFFFF3B2F),
            t6 = Color(0xFFA40E26),
            t7 = Color(0xFF82071E),
            t8 = Color(0xFF660018),
            t9 = Color(0xFF4C0014)
        ),
        purple = Colors.Purple(
            t0 = Color(0xFFFBEFFF),
            t1 = Color(0xFFECD8FF),
            t2 = Color(0xFFD8B9FF),
            t3 = Color(0xFFC297FF),
            t4 = Color(0xFFA475F9),
            t5 = Color(0xFF8250DF),
            t6 = Color(0xFF6639BA),
            t7 = Color(0xFF512A97),
            t8 = Color(0xFF3E1F79),
            t9 = Color(0xFF2E1461)
        ),
        pink = Colors.Pink(
            t0 = Color(0xFFFFEFF7),
            t1 = Color(0xFFFFD3EB),
            t2 = Color(0xFFFFADDA),
            t3 = Color(0xFFFF80C8),
            t4 = Color(0xFFE85AAD),
            t5 = Color(0xFFBF3989),
            t6 = Color(0xFF99286E),
            t7 = Color(0xFF772057),
            t8 = Color(0xFF611347),
            t9 = Color(0xFF4D0336)
        ),
        background = Colors.Background(Color(0xFFFFFFFF)),
        black = Colors.Black(Color(0xFF000000)),
        white = Colors.White(Color(0xFFFFFFFF)),
        yellow = Colors.Yellow(t1 = Color(0xFFFFF7C8), t5 = Color(0xFFFFCC00))
    )

    val darkColors = Colors(
        gray = Colors.Gray(
            t0 = Color(0xFF24292F),
            t1 = Color(0xFF32383F),
            t2 = Color(0xFF424A53),
            t3 = Color(0xFF57606A),
            t4 = Color(0xFF6E7781),
            t5 = Color(0xFF8C959F),
            t6 = Color(0xFFAFB8C1),
            t7 = Color(0xFFD0D7DE),
            t8 = Color(0xFFEAEEF2),
            t9 = Color(0xFFF6F8FA)
        ),
        primary = Colors.Primary(
            t0 = Color(0xFF001532),
            t1 = Color(0xFF001F4A),
            t2 = Color(0xFF002963),
            t3 = Color(0xFF003988),
            t4 = Color(0xFF0047AB),
            t5 = Color(0xFF0A84FF),
            t6 = Color(0xFF408CFF),
            t7 = Color(0xFF80B3FF),
            t8 = Color(0xFFC0D9FF),
            t9 = Color(0xFFE0ECFF)
        ),
        caution = Colors.Caution(
            t0 = Color(0xFF5B4D00),
            t1 = Color(0xFF927C00),
            t2 = Color(0xFFB69B00),
            t3 = Color(0xFFDBBA00),
            t4 = Color(0xFFFFD800),
            t5 = Color(0xFFFFDE24),
            t6 = Color(0xFFFFE65B),
            t7 = Color(0xFFFFEF92),
            t8 = Color(0xFFFFF7C8),
            t9 = Color(0xFFFFFADB)
        ),
        warning = Colors.Warning(
            t0 = Color(0xFF491800),
            t1 = Color(0xFF802B00),
            t2 = Color(0xFFB63D00),
            t3 = Color(0xFFDB4900),
            t4 = Color(0xFFFF5400),
            t5 = Color(0xFFFF6D24),
            t6 = Color(0xFFFF8649),
            t7 = Color(0xFFFF925B),
            t8 = Color(0xFFFFB692),
            t9 = Color(0xFFFFE7DB)
        ),
        success = Colors.Success(
            t0 = Color(0xFF065F43),
            t1 = Color(0xFF0B7247),
            t2 = Color(0xFF118D4E),
            t3 = Color(0xFF1AAA52),
            t4 = Color(0xFF23C653),
            t5 = Color(0xFF2FD159),
            t6 = Color(0xFF78ED84),
            t7 = Color(0xFFA7F9A7),
            t8 = Color(0xFFD6FDD1),
            t9 = Color(0xFFEBFDE9)
        ),
        error = Colors.Error(
            t0 = Color(0xFF4C0014),
            t1 = Color(0xFF660018),
            t2 = Color(0xFF82071E),
            t3 = Color(0xFFA40E26),
            t4 = Color(0xFFCF222E),
            t5 = Color(0xFFFF4539),
            t6 = Color(0xFFFF8182),
            t7 = Color(0xFFFFABA8),
            t8 = Color(0xFFFFCECB),
            t9 = Color(0xFFFFEBE9)
        ),
        purple = Colors.Purple(
            t0 = Color(0xFF2E1461),
            t1 = Color(0xFF3E1F79),
            t2 = Color(0xFF512A97),
            t3 = Color(0xFF6639BA),
            t4 = Color(0xFF8250DF),
            t5 = Color(0xFFA475F9),
            t6 = Color(0xFFC297FF),
            t7 = Color(0xFFD8B9FF),
            t8 = Color(0xFFECD8FF),
            t9 = Color(0xFFFBEFFF)
        ),
        pink = Colors.Pink(
            t0 = Color(0xFF4D0336),
            t1 = Color(0xFF611347),
            t2 = Color(0xFF772057),
            t3 = Color(0xFF99286E),
            t4 = Color(0xFFBF3989),
            t5 = Color(0xFFE85AAD),
            t6 = Color(0xFFFF80C8),
            t7 = Color(0xFFFFADDA),
            t8 = Color(0xFFFFD3EB),
            t9 = Color(0xFFFFEFF7)
        ),
        background = Colors.Background(Color(0xFF1E2328)),
        black = Colors.Black(Color(0xFF000000)),
        white = Colors.White(Color(0xFFFFFFFF)),
        yellow = Colors.Yellow(t1 = Color(0xFF927c00), t5 = Color(0xFFFFD60A))
    )
}

internal val LocalColors = staticCompositionLocalOf { ComposeRantColor.lightColors }