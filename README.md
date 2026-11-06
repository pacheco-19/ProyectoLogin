# 🚀 Órbita — App de Login y Bienvenida

App Android hecha con **Kotlin**, **Jetpack Compose** y **Material 3** para la asignatura de *Programación multimedia y dispositivos móviles* (2.º DAM).

La app tiene dos pantallas con temática espacial:

- **Login**: el usuario escribe su correo y su contraseña. Si son correctos, "despega".
- **Bienvenida**: saluda al usuario por su nombre y le deja cerrar sesión.

---

## 🔑 Datos de prueba

| Campo | Valor |
|---|---|
| Correo | `alejandro@orbita.app` |
| Contraseña | `despegue` |
| Nombre que se muestra | Alejandro |

> Están escritos como constantes al principio de `ui/LoginScreen.kt`. En una app real vendrían de un servidor o de una base de datos.

---

## 📱 Qué hace la app

### Pantalla 1 — Login
- Logo con un **cohete** dentro de un círculo.
- Campo de **correo** y campo de **contraseña** ("Código de lanzamiento").
- Botón con un **ojo** para mostrar u ocultar la contraseña.
- Botón **Despegar**:
    - Si los datos son correctos → pasa a la pantalla de Bienvenida.
    - Si son incorrectos → los campos se ponen en rojo y sale el mensaje *"Coordenadas incorrectas"*.
- En cuanto el usuario vuelve a escribir, el error desaparece.

### Pantalla 2 — Bienvenida
- Logo con un **planeta** (el mismo componente que en el login, con otro icono).
- Saludo *"¡Bienvenido a bordo, Alejandro!"*. El nombre **no está escrito en esta pantalla**: llega como parámetro desde el login.
- Un dibujo hecho con **Canvas**: planeta con anillo, luna y estrellas.
- Botón **Cerrar sesión** que vuelve al login con los campos vacíos.

---

## 🗂️ Estructura del proyecto

```
com.pacheco.proyectologin
├── MainActivity.kt        → decide qué pantalla se ve
└── ui
    ├── LogoCircular.kt    → logo reutilizable (círculo + icono)
    ├── LoginScreen.kt     → pantalla 1
    ├── WelcomeScreen.kt   → pantalla 2 + dibujo con Canvas
    └── theme
        ├── Color.kt       → colores (modo claro y oscuro)
        ├── Theme.kt       → tema de Material 3
        └── Type.kt        → tipografía
```

Iconos usados (en `res/drawable`): `ic_cohete`, `ic_planeta`, `ic_visibility` e `ic_visibility_off`.

---

## 🧠 Cómo funciona (explicado fácil)

**1. La pantalla depende de un estado.**
En Compose una pantalla es una función que dibuja la interfaz a partir de unas variables (el *estado*). Cuando una variable cambia, Compose vuelve a dibujar la pantalla solo.

```kotlin
var email by rememberSaveable { mutableStateOf("") }
```
- `mutableStateOf` → avisa a Compose cuando el valor cambia.
- `rememberSaveable` → guarda el valor aunque se gire el móvil.

**2. Las pantallas no se abren entre ellas.**
El login no sabe que existe la bienvenida. Cuando el usuario acierta, solo avisa:

```kotlin
onLoginCorrecto(NOMBRE_USUARIO)
```

**3. Un solo estado decide qué se ve.**
En `MainActivity` hay una variable `nombreUsuario`:

| `nombreUsuario` | Significa | Se ve |
|---|---|---|
| `null` | nadie ha iniciado sesión | Login |
| `"Alejandro"` | sesión iniciada | Bienvenida |

Flujo completo:
1. El login acierta → llama a `onLoginCorrecto("Alejandro")`.
2. `MainActivity` guarda el nombre: `nombreUsuario = "Alejandro"`.
3. Compose redibuja y ahora muestra `WelcomeScreen(nombre = "Alejandro")`.
4. Al pulsar *Cerrar sesión* → `nombreUsuario = null` → vuelve el login.

> **Los datos bajan como parámetros y los eventos suben como funciones.**

---

## 🎨 Decisiones de diseño

- **Temática espacial**: iniciar sesión es "despegar". Por eso el login lleva un cohete y la bienvenida un planeta.
- **Colores**: índigo como color principal (cielo nocturno), naranja para los detalles (fuego del cohete) y turquesa para la luna. Todos están en `Color.kt` y son los mismos que en Figma.
- **Material 3**: las pantallas nunca usan colores sueltos, siempre `MaterialTheme.colorScheme`, para que todo cambie a la vez si se cambia el tema.
- **Sin color dinámico**: se quitó para que la app se vea igual en todos los móviles.
- **Textos con personalidad**: "Hola, astronauta", "Código de lanzamiento", "Despegar"…

---

## ⭐ Extras añadidos

1. **Modo oscuro**: la app cambia de colores si el móvil está en tema oscuro.
2. **Botón desactivado** si el correo o la contraseña están vacíos.
3. **Componente reutilizable** `LogoCircular`, usado en las dos pantallas.
4. **Dibujo propio con Canvas** en la pantalla de bienvenida.
5. **Vista previa** (`@Preview`) de cada pantalla en modo claro y oscuro.

---

## ▶️ Cómo ejecutarla

1. Clonar o descargar el repositorio.
2. Abrirlo con **Android Studio**.
3. Esperar a que Gradle termine de sincronizar.
4. Elegir un emulador (o un móvil conectado) y pulsar ▶ **Run**.

**Requisitos:** Android 8.0 (API 26) o superior.

---

## 🔗 Enlaces

- Diseño en Figma: *(pegar enlace)*
- Vídeo de demostración: *(pegar enlace)*

---

**Autor:** Alejandro Pacheco · 2.º DAM