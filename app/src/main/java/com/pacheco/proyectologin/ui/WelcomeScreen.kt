package com.pacheco.proyectologin.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pacheco.proyectologin.R
import com.pacheco.proyectologin.ui.theme.OrbitaTheme

/*
 * PANTALLA 2: BIENVENIDA
 *
 * Recibe DOS cosas desde fuera:
 *   - nombre: el nombre del usuario, que solo mostramos (parámetro de DATOS)
 *   - onCerrarSesion: función que llamamos al pulsar el botón (parámetro de ACCIÓN)
 * La pantalla no sabe qué pasa al cerrar sesión: eso lo decide MainActivity.
 */
@Composable
fun WelcomeScreen(
    nombre: String,
    onCerrarSesion: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,   // todo centrado
    ) {
        Spacer(Modifier.height(48.dp))

        // Mismo logo que en el login, pero con el planeta
        LogoCircular(icono = R.drawable.ic_planeta)

        Spacer(Modifier.height(24.dp))
        Text(
            text = "INICIO DE SESIÓN COMPLETADO",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.secondary,
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "¡Bienvenido a bordo,",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Text(
            text = "$nombre!",   // <- el parámetro que nos manda el login
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
        )

        Spacer(Modifier.height(24.dp))

        // weight(1f): el dibujo ocupa todo el hueco libre,
        // así el botón queda siempre abajo del todo
        DibujoPlaneta(modifier = Modifier.weight(1f))

        Spacer(Modifier.height(24.dp))

        // Botón con borde, centrado gracias al horizontalAlignment de la Column
        OutlinedButton(
            onClick = onCerrarSesion,   // llamamos a la función que nos han pasado
            colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.primary),
        ) {
            Text("Cerrar sesión")
        }

        Spacer(Modifier.height(16.dp))
    }
}

/**
 * Dibujo propio hecho con Canvas: un planeta con anillo, una luna y estrellas.
 *
 * Las medidas están pensadas para un cuadrado de 300 x 300 y se escalan
 * con "u" para que el dibujo quepa en cualquier pantalla sin deformarse.
 */
@Composable
private fun DibujoPlaneta(modifier: Modifier = Modifier) {
    // Los colores se leen del tema ANTES de entrar al Canvas
    val colorPlaneta = MaterialTheme.colorScheme.primary
    val colorAnillo = MaterialTheme.colorScheme.secondary
    val colorLuna = MaterialTheme.colorScheme.tertiary
    val colorEstrellas = MaterialTheme.colorScheme.outline

    Canvas(modifier = modifier.fillMaxWidth()) {
        // "u" = unidad de escala (el lado más pequeño manda)
        val u = minOf(size.width / 300f, size.height / 300f)

        // Movemos el dibujo para que quede centrado en el hueco
        translate(left = (size.width - 300f * u) / 2f, top = (size.height - 300f * u) / 2f) {
            val centro = Offset(150f * u, 150f * u)

            // 1) Planeta: un círculo grande
            drawCircle(color = colorPlaneta, radius = 70f * u, center = centro)

            // 2) Anillo: un óvalo (solo el borde) inclinado 20 grados
            rotate(degrees = -20f, pivot = centro) {
                drawOval(
                    color = colorAnillo,
                    topLeft = Offset(40f * u, 125f * u),
                    size = Size(220f * u, 50f * u),
                    style = Stroke(width = 8f * u),   // Stroke = solo el borde, sin relleno
                )
            }

            // 3) Luna: un círculo pequeño arriba a la derecha
            drawCircle(color = colorLuna, radius = 16f * u, center = Offset(250f * u, 60f * u))

            // 4) Estrellas: puntitos repartidos alrededor
            drawCircle(colorEstrellas, 4f * u, Offset(40f * u, 50f * u))
            drawCircle(colorEstrellas, 3f * u, Offset(150f * u, 25f * u))
            drawCircle(colorEstrellas, 5f * u, Offset(30f * u, 230f * u))
            drawCircle(colorEstrellas, 3f * u, Offset(270f * u, 200f * u))
            drawCircle(colorEstrellas, 4f * u, Offset(200f * u, 280f * u))
        }
    }
}

// Vistas previas. El nombre aquí es solo de ejemplo.
@Preview(name = "Bienvenida claro", showBackground = true, widthDp = 360, heightDp = 780)
@Composable
private fun WelcomeScreenPreview() {
    OrbitaTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colorScheme.background) {
            WelcomeScreen(nombre = "Alejandro", onCerrarSesion = {})
        }
    }
}

@Preview(name = "Bienvenida oscuro", showBackground = true, widthDp = 360, heightDp = 780)
@Composable
private fun WelcomeScreenDarkPreview() {
    OrbitaTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colorScheme.background) {
            WelcomeScreen(nombre = "Alejandro", onCerrarSesion = {})
        }
    }
}
