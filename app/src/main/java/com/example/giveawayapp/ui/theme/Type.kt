package com.example.giveawayapp.ui.theme
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.giveawayapp.R

private val Montserrat = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_medium, FontWeight.W500),
    Font(R.font.montserrat_semibold, FontWeight.W600)
)

private val Inter = FontFamily(
    Font(R.font.inter300light),
    Font(R.font.inter_roman, FontWeight.W500),
    Font(R.font.inter_600semi_bold, FontWeight.W600)
)

/**
 * https://fonts.google.com/specimen/Domine
 */
private val Domine = FontFamily(
    Font(R.font.domine_regular),
    Font(R.font.domine_bold, FontWeight.Bold)
)

private val Roboto= FontFamily(
    Font(R.font.roboto_500medium, FontWeight.W500),
    Font(R.font.roboto_300light, FontWeight.W400),
    Font(R.font.roboto_700bold, FontWeight.W600),
    Font(R.font.roboto_100thin, FontWeight.W300)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.W600,
        fontSize = 45.sp
    ),
    h2 = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.W600,
        fontSize = 35.sp
    ),
    h3 = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    h4 = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp
    ),
    h5 = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp
    ),
    h6 = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.W400,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.W300,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = FontFamily.Serif,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    overline = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    )
)