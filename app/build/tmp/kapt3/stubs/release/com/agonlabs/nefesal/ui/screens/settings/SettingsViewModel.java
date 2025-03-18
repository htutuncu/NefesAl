package com.agonlabs.nefesal.ui.screens.settings;

import androidx.lifecycle.ViewModel;
import com.agonlabs.nefesal.util.PreferencesManager;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u0012\u001a\u00020\u0010R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/agonlabs/nefesal/ui/screens/settings/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "preferencesManager", "Lcom/agonlabs/nefesal/util/PreferencesManager;", "(Lcom/agonlabs/nefesal/util/PreferencesManager;)V", "_isDarkMode", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_selectedLanguage", "", "isDarkMode", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "selectedLanguage", "getSelectedLanguage", "setLanguage", "", "languageCode", "toggleDarkMode", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.agonlabs.nefesal.util.PreferencesManager preferencesManager = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _selectedLanguage = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> selectedLanguage = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isDarkMode = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isDarkMode = null;
    
    @javax.inject.Inject
    public SettingsViewModel(@org.jetbrains.annotations.NotNull
    com.agonlabs.nefesal.util.PreferencesManager preferencesManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSelectedLanguage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isDarkMode() {
        return null;
    }
    
    public final void setLanguage(@org.jetbrains.annotations.Nullable
    java.lang.String languageCode) {
    }
    
    public final void toggleDarkMode() {
    }
}