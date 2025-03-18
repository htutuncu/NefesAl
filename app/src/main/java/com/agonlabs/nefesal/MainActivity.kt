package com.agonlabs.nefesal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.agonlabs.nefesal.ui.NefesAlApp
import com.agonlabs.nefesal.ui.theme.NefesAlTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            NefesAlTheme {
                NefesAlApp()
            }
        }
    }
}