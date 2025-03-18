package com.agonlabs.nefesal.ui.screens.settings;

import androidx.compose.foundation.layout.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import com.agonlabs.nefesal.R;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.text.font.FontWeight;
import androidx.navigation.NavController;
import com.agonlabs.nefesal.data.PolicyType;
import com.agonlabs.nefesal.navigation.Screen;
import com.agonlabs.nefesal.ui.screens.home.HomeViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007\u00a2\u0006\u0002\b\tH\u0007\u001a6\u0010\n\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001aE\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007\u00a2\u0006\u0002\b\tH\u0007\u001a$\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u00a8\u0006\u001a"}, d2 = {"DialogOption", "", "text", "", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "Landroidx/compose/runtime/Composable;", "LanguageSelectionDialog", "selectedLanguage", "onLanguageSelected", "Lkotlin/Function1;", "onDismiss", "SettingsItem", "title", "subtitle", "trailing", "SettingsScreen", "viewModel", "Lcom/agonlabs/nefesal/ui/screens/settings/SettingsViewModel;", "homeViewModel", "Lcom/agonlabs/nefesal/ui/screens/home/HomeViewModel;", "navController", "Landroidx/navigation/NavController;", "app_release"})
public final class SettingsScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void SettingsScreen(@org.jetbrains.annotations.NotNull
    com.agonlabs.nefesal.ui.screens.settings.SettingsViewModel viewModel, @org.jetbrains.annotations.NotNull
    com.agonlabs.nefesal.ui.screens.home.HomeViewModel homeViewModel, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SettingsItem(@org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.Nullable
    java.lang.String subtitle, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function0<kotlin.Unit> trailing) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void LanguageSelectionDialog(@org.jetbrains.annotations.Nullable
    java.lang.String selectedLanguage, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onLanguageSelected, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void DialogOption(@org.jetbrains.annotations.NotNull
    java.lang.String text, boolean selected, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> icon) {
    }
}