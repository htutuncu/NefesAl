package com.agonlabs.nefesal.ui.screens.settings.policies;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.tooling.preview.Preview;
import androidx.navigation.NavController;
import com.agonlabs.nefesal.data.PolicyType;
import com.agonlabs.nefesal.ui.screens.settings.SettingsViewModel;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\"\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\b\u0010\r\u001a\u00020\u0001H\u0007\u001a\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0002\u00a8\u0006\u0012"}, d2 = {"MultiLanguageHtmlView", "", "language", "", "isDarkMode", "", "policyType", "Lcom/agonlabs/nefesal/data/PolicyType;", "PoliciesScreen", "viewModel", "Lcom/agonlabs/nefesal/ui/screens/settings/SettingsViewModel;", "navController", "Landroidx/navigation/NavController;", "Preview", "loadHtmlFromAssets", "context", "Landroid/content/Context;", "fileName", "app_release"})
public final class PoliciesScreenKt {
    
    @android.annotation.SuppressLint(value = {"UnusedMaterial3ScaffoldPaddingParameter"})
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void PoliciesScreen(@org.jetbrains.annotations.NotNull
    com.agonlabs.nefesal.ui.screens.settings.SettingsViewModel viewModel, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull
    com.agonlabs.nefesal.data.PolicyType policyType) {
    }
    
    @android.annotation.SuppressLint(value = {"SetJavaScriptEnabled"})
    @androidx.compose.runtime.Composable
    public static final void MultiLanguageHtmlView(@org.jetbrains.annotations.NotNull
    java.lang.String language, boolean isDarkMode, @org.jetbrains.annotations.NotNull
    com.agonlabs.nefesal.data.PolicyType policyType) {
    }
    
    private static final java.lang.String loadHtmlFromAssets(android.content.Context context, java.lang.String fileName) {
        return null;
    }
    
    @androidx.compose.ui.tooling.preview.Preview
    @androidx.compose.runtime.Composable
    public static final void Preview() {
    }
}