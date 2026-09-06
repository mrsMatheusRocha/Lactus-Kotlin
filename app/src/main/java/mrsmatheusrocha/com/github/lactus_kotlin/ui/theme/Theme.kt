package mrsmatheusrocha.com.github.lactus_kotlin.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = AmareloPrimary,
    onPrimary = AzulEscuro,
    secondary = AzulEscuro,
    onSecondary = White,
    tertiary = AzulClaro, // Equivalente ao --accent
    background = BackgroundLight,
    onBackground = ForegroundLight,
    surface = CardLight,
    onSurface = ForegroundLight,
    surfaceVariant = MutedLight, // Equivalente ao --muted
    error = Destructive
)

private val DarkColorScheme = darkColorScheme(
    primary = AmareloPrimary,
    onPrimary = BackgroundDark, // Texto quase preto para contraste no escuro
    secondary = AzulClaro, // O Azul Claro vira secundário no escuro, conforme seu CSS
    onSecondary = White,
    tertiary = AzulEscuro, // O Azul Escuro vira accent no escuro
    background = BackgroundDark,
    onBackground = ForegroundDark,
    surface = CardDark,
    onSurface = ForegroundDark,
    surfaceVariant = MutedDark,
    error = Destructive
)

@Composable
fun LactusTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}