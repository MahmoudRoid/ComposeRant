package parniyan.mahmoudroid.compose.base.presentation.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import parniyan.mahmoudroid.compose.base.R
import parniyan.mahmoudroid.compose.base.presentation.ui.theme.foundation.Typography

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */


internal object ComposeRantTypography {

    private val sfProDisplayFamily = FontFamily(
        Font(R.font.sf_pro_display_regular, FontWeight.Normal),
        Font(R.font.sf_pro_display_medium, FontWeight.Medium),
        Font(R.font.sf_pro_display_bold, FontWeight.Bold),
    )

    //Note: regular is normal
    private val normalTextStyle =
        TextStyle(fontFamily = sfProDisplayFamily, fontWeight = FontWeight.Normal)
    private val mediumTextStyle =
        TextStyle(fontFamily = sfProDisplayFamily, fontWeight = FontWeight.Medium)
    private val boldTextStyle =
        TextStyle(fontFamily = sfProDisplayFamily, fontWeight = FontWeight.Bold)

    val typography = Typography(
        regular = Typography.Regular(
            h1 = normalTextStyle + TextStyle(fontSize = 36.sp, lineHeight = 48.sp),
            h2 = normalTextStyle + TextStyle(fontSize = 32.sp, lineHeight = 40.sp),
            h3 = normalTextStyle + TextStyle(fontSize = 24.sp, lineHeight = 28.sp),
            title1 = normalTextStyle + TextStyle(fontSize = 20.sp, lineHeight = 24.sp),
            title2 = normalTextStyle + TextStyle(fontSize = 18.sp, lineHeight = 24.sp),
            body1 = normalTextStyle + TextStyle(fontSize = 16.sp, lineHeight = 20.sp),
            body2 = normalTextStyle + TextStyle(fontSize = 14.sp, lineHeight = 16.sp),
            caption1 = normalTextStyle + TextStyle(fontSize = 12.sp, lineHeight = 16.sp),
            caption2 = normalTextStyle + TextStyle(fontSize = 10.sp, lineHeight = 12.sp),
        ),
        medium = Typography.Medium(
            title2 = mediumTextStyle + TextStyle(fontSize = 18.sp, lineHeight = 24.sp),
            body1 = mediumTextStyle + TextStyle(fontSize = 16.sp, lineHeight = 20.sp),
            body2 = mediumTextStyle + TextStyle(fontSize = 14.sp, lineHeight = 16.sp),
            caption1 = mediumTextStyle + TextStyle(fontSize = 12.sp, lineHeight = 16.sp)
        ),
        bold = Typography.Bold(
            h1 = boldTextStyle + TextStyle(fontSize = 36.sp, lineHeight = 48.sp),
            h2 = boldTextStyle + TextStyle(fontSize = 32.sp, lineHeight = 40.sp),
            h3 = boldTextStyle + TextStyle(fontSize = 24.sp, lineHeight = 28.sp),
            title1 = boldTextStyle + TextStyle(fontSize = 20.sp, lineHeight = 24.sp),
            title2 = boldTextStyle + TextStyle(fontSize = 18.sp, lineHeight = 24.sp),
            body1 = boldTextStyle + TextStyle(fontSize = 16.sp, lineHeight = 20.sp),
            body2 = boldTextStyle + TextStyle(fontSize = 14.sp, lineHeight = 16.sp),
            caption1 = boldTextStyle + TextStyle(fontSize = 12.sp, lineHeight = 16.sp),
            caption2 = boldTextStyle + TextStyle(fontSize = 10.sp, lineHeight = 12.sp),
        ),
    )

}

internal val LocalTypography = staticCompositionLocalOf { ComposeRantTypography.typography }