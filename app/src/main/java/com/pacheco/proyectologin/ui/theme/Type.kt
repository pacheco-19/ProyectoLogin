package com.pacheco.proyectologin.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Partimos de la escala de Material 3 (Roboto) y solo tocamos 3 estilos
// para darle personalidad "espacial". Son los estilos de texto de Figma.
private val TipografiaBase = Typography()

val Typography = Typography(
    // Títulos ("Hola, astronauta"): en negrita
    headlineMedium = TipografiaBase.headlineMedium.copy(fontWeight = FontWeight.Bold),
    // Texto de los botones: un poco más separado
    labelLarge = TipografiaBase.labelLarge.copy(letterSpacing = 1.sp),
    // Etiquetas tipo "MISIÓN ÓRBITA": letra de ordenador de la NASA (monoespaciada)
    labelSmall = TipografiaBase.labelSmall.copy(
        fontFamily = FontFamily.Monospace,
        letterSpacing = 2.sp,
    ),
)