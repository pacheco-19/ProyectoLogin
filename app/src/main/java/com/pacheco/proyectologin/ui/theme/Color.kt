package com.pacheco.proyectologin.ui.theme

import androidx.compose.ui.graphics.Color

// =====================================================================
//  PALETA "ÓRBITA"
//  Tema espacial: índigo de cielo nocturno + naranja de fuego de cohete
//  + turquesa de la ventanilla. Son los MISMOS colores que las variables
//  de Figma (colección "Orbita Colores", modos Claro y Oscuro).
// =====================================================================

// ---------- MODO CLARO (cielo de día) ----------
val PrimaryLight = Color(0xFF3D3A8C)              // índigo: botones, nombre del usuario, planeta del logo
val OnPrimaryLight = Color(0xFFFFFFFF)            // texto encima del botón principal
val PrimaryContainerLight = Color(0xFFE2DFFF)     // fondo del logo y cuerpo del cohete
val OnPrimaryContainerLight = Color(0xFF0F0A5C)
val SecondaryLight = Color(0xFFC2410C)            // naranja "fuego": aletas, llama, etiquetas
val SecondaryContainerLight = Color(0xFFFFD8A8)   // amarillo del interior de la llama
val TertiaryLight = Color(0xFF0E7C86)             // turquesa: ventanilla y satélite
val SurfaceLight = Color(0xFFF8F7FF)              // fondo de pantalla
val OnSurfaceLight = Color(0xFF1B1B21)            // texto principal
val OnSurfaceVariantLight = Color(0xFF47464F)     // texto secundario
val OutlineLight = Color(0xFF787680)              // bordes de campos y estrellas
val OutlineVariantLight = Color(0xFFC8C5D0)       // humo del cohete

// ---------- MODO OSCURO (espacio de noche) ----------
val PrimaryDark = Color(0xFFC3C0FF)
val OnPrimaryDark = Color(0xFF242062)
val PrimaryContainerDark = Color(0xFF3B3880)
val OnPrimaryContainerDark = Color(0xFFE2DFFF)
val SecondaryDark = Color(0xFFFFB59A)
val SecondaryContainerDark = Color(0xFFFFD8A8)    // la llama brilla igual de día y de noche
val TertiaryDark = Color(0xFF7DD3DC)
val SurfaceDark = Color(0xFF12121C)               // casi negro, con un toque azul
val OnSurfaceDark = Color(0xFFE4E1EC)
val OnSurfaceVariantDark = Color(0xFFC8C5D0)
val OutlineDark = Color(0xFF928F9A)
val OutlineVariantDark = Color(0xFF47464F)