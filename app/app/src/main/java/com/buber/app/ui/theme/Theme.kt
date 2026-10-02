package com.buber.app.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)
val Gray100 = Color(0xFFF3F3F3)
val Gray300 = Color(0xFFD9D9D9)
val Gray600 = Color(0xFF6B6B6B)
val Accent = Color(0xFF276EF1)

private val Scheme = lightColorScheme(
    primary = Black, onPrimary = White,
    secondary = Gray100, onSecondary = Black,
    background = White, onBackground = Black,
    surface = White, onSurface = Black,
    surfaceVariant = Gray100, onSurfaceVariant = Gray600,
    outline = Gray300, tertiary = Accent,
)

private val Type = Typography(
    headlineMedium = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
    titleLarge = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold),
    titleMedium = TextStyle(fontSize = 17.sp, fontWeight = FontWeight.SemiBold),
    bodyLarge = TextStyle(fontSize = 16.sp),
    bodyMedium = TextStyle(fontSize = 14.sp),
    labelMedium = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium),
)

private val Shapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(14.dp),
    large = RoundedCornerShape(24.dp),
)

@Composable
fun BuberTheme(content: @Composable () -> Unit) =
    MaterialTheme(colorScheme = Scheme, typography = Type, shapes = Shapes, content = content)
