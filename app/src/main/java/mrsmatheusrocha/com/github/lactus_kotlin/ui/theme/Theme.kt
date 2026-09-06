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
    tertiary = AzulClaro,
    background = BackgroundLight,
    onBackground = ForegroundLight,
    surface = CardLight,
    onSurface = ForegroundLight,
    surfaceVariant = MutedLight,
    error = Destructive
)

private val DarkColorScheme = darkColorScheme(
    primary = AmareloPrimary,
    onPrimary = BackgroundDark,
    secondary = AzulClaro,
    onSecondary = White,
    tertiary = AzulEscuro,
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