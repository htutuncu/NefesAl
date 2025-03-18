package com.agonlabs.nefesal.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.agonlabs.nefesal.ui.screens.home.HomeViewModel

private val LightColorScheme = lightColorScheme(
    primary = Green60,
    onPrimary = Color.White,
    primaryContainer = Green20,
    onPrimaryContainer = Green70,
    secondary = Green40,
    onSecondary = Color.White,
    secondaryContainer = Green10,
    onSecondaryContainer = Green60,
    tertiary = GreenGray30,
    onTertiary = Color.White,
    tertiaryContainer = GreenGray10,
    onTertiaryContainer = GreenGray30,
    background = Green10,
    surface = Green10,
    surfaceVariant = Green20,
    onSurfaceVariant = GreenGray20
)

private val DarkColorScheme = darkColorScheme(
    primary = Green40,
    onPrimary = Green70,
    primaryContainer = Green60,
    onPrimaryContainer = Green20,
    secondary = Green30,
    onSecondary = Green70,
    secondaryContainer = Green50,
    onSecondaryContainer = Green20,
    tertiary = GreenGray20,
    onTertiary = Color.White,
    tertiaryContainer = GreenGray30,
    onTertiaryContainer = GreenGray10,
    background = Color(0xFF1A1C19),
    surface = Color(0xFF1A1C19),
    surfaceVariant = GreenGray30,
    onSurfaceVariant = GreenGray10
)

@Composable
fun NefesAlTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    viewModel: HomeViewModel = hiltViewModel(),
    // Dynamic color'ı false yapıyoruz ki kendi renklerimizi kullanalım
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val isDarkMode by viewModel.isDarkMode.collectAsState()

    val colorScheme = when {
        // Artık bu koşul hiç çalışmayacak çünkü dynamicColor false
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (isDarkMode) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        isDarkMode -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !isDarkMode
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}