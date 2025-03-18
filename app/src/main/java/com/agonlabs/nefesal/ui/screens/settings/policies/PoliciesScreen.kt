package com.agonlabs.nefesal.ui.screens.settings.policies

import android.annotation.SuppressLint
import android.content.Context
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.agonlabs.nefesal.data.PolicyType
import com.agonlabs.nefesal.ui.screens.settings.SettingsViewModel
import java.io.BufferedReader
import java.io.InputStreamReader

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PoliciesScreen(
    viewModel: SettingsViewModel = hiltViewModel(),
    navController: NavController,
    policyType: PolicyType
) {
    val isDarkMode by viewModel.isDarkMode.collectAsState()
    val selectedLanguage by viewModel.selectedLanguage.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = policyType.getTitle()) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Geri",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                windowInsets = WindowInsets(0, 0, 0, 0)
            )
        }
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp))
        {
            MultiLanguageHtmlView(selectedLanguage.orEmpty(), isDarkMode, policyType)
        }
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun MultiLanguageHtmlView(language: String, isDarkMode: Boolean, policyType: PolicyType) {
    val context = LocalContext.current
    val htmlContent = loadHtmlFromAssets(context, policyType.getFileName())

    AndroidView(
        factory = { WebView(context).apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadDataWithBaseURL(
                null,
                htmlContent
                    .replace("{{language}}", language)
                    .replace("{{isDarkMode}}", isDarkMode.toString()),
                "text/html; charset=utf-8", "UTF-8", null
            )
        }},
        modifier = Modifier.fillMaxSize()
    )
}

private fun loadHtmlFromAssets(context: Context, fileName: String): String {
    val inputStream = context.assets.open(fileName)
    val reader = BufferedReader(InputStreamReader(inputStream))
    return reader.use { it.readText() }
}

@Preview
@Composable
fun Preview() {

}