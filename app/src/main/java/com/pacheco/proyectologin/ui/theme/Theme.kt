package com.pacheco.proyectologin.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

// Cada color de Color.kt se asigna a su ROL de Material 3.
// Los componentes (Button, OutlinedTextField...) leen estos roles solos.
private val LightColorScheme = lightColorScheme(
    primary = PrimaryLight,
    onPrimary = OnPrimaryLight,
    primaryContainer = PrimaryContainerLight,
    onPrimaryContainer = OnPrimaryContainerLight,
    secondary = SecondaryLight,
    secondaryContainer = SecondaryContainerLight,
    tertiary = TertiaryLight,
    surface = SurfaceLight,
    onSurface = OnSurfaceLight,
    onSurfaceVariant = OnSurfaceVariantLight,
    outline = OutlineLight,
    outlineVariant = OutlineVariantLight,
    background = SurfaceLight,      // el Scaffold usa "background": lo igualamos a surface
    onBackground = OnSurfaceLight,
)

// EXTRA: modo oscuro con los mismos roles pero colores de "noche espacial".
private val DarkColorScheme = darkColorScheme(
    primary = PrimaryDark,
    onPrimary = OnPrimaryDark,
    primaryContainer = PrimaryContainerDark,
    onPrimaryContainer = OnPrimaryContainerDark,
    secondary = SecondaryDark,
    secondaryContainer = SecondaryContainerDark,
    tertiary = TertiaryDark,
    surface = SurfaceDark,
    onSurface = OnSurfaceDark,
    onSurfaceVariant = OnSurfaceVariantDark,
    outline = OutlineDark,
    outlineVariant = OutlineVariantDark,
    background = SurfaceDark,
    onBackground = OnSurfaceDark,
)

/**
 * Tema de la app Órbita.
 * - darkTheme: por defecto sigue al ajuste del móvil (isSystemInDarkTheme).
 * - Quitamos el "color dinámico" de la plantilla para que la app se vea
 *   siempre igual que el diseño de Figma.
 */
@Composable
fun OrbitaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content,
    )
}