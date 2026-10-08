package com.buber.app.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Paleta escura inspirada no Uber. Os nomes foram mantidos para o resto do app continuar compilando:
//   Gray100 = cartões/superfícies elevadas, Gray300 = bordas, Gray600 = texto secundário.
val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)
val SurfaceDark = Color(0xFF121212)
val Gray100 = Color(0xFF1E1E1E)
val Gray300 = Color(0xFF3A3A3A)
val Gray600 = Color(0xFFA6A6A6)
val Accent = Color(0xFF3B82F6)

private val Scheme = darkColorScheme(
    primary = White, onPrimary = Black,
    secondary = Gray100, onSecondary = White,
    secondaryContainer = Gray100, onSecondaryContainer = White,
    background = Black, onBackground = White,
    surface = SurfaceDark, onSurface = White,
    surfaceVariant = Gray100, onSurfaceVariant = Gray600,
    surfaceContainer = SurfaceDark, surfaceContainerHigh = Gray100,
    outline = Gray300, outlineVariant = Gray300,
    tertiary = Accent,
    error = Color(0xFFFF6B6B), onError = Black,
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
