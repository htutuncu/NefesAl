package com.agonlabs.nefesal.ui.screens.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onSplashComplete: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(2000) // 2 saniye bekle
        onSplashComplete()
    }
    
    // Splash ekranı tasarımı buraya gelecek
} 