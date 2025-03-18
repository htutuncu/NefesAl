package com.agonlabs.nefesal.ui;

import androidx.lifecycle.ViewModel;
import com.agonlabs.nefesal.util.PreferencesManager;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import java.util.Locale;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/agonlabs/nefesal/ui/LocaleViewModel;", "Landroidx/lifecycle/ViewModel;", "preferencesManager", "Lcom/agonlabs/nefesal/util/PreferencesManager;", "(Lcom/agonlabs/nefesal/util/PreferencesManager;)V", "_currentLocale", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ljava/util/Locale;", "kotlin.jvm.PlatformType", "currentLocale", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentLocale", "()Lkotlinx/coroutines/flow/StateFlow;", "setCurrentDefaultLocale", "", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class LocaleViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.agonlabs.nefesal.util.PreferencesManager preferencesManager = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Locale> _currentLocale = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.Locale> currentLocale = null;
    
    @javax.inject.Inject
    public LocaleViewModel(@org.jetbrains.annotations.NotNull
    com.agonlabs.nefesal.util.PreferencesManager preferencesManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.Locale> getCurrentLocale() {
        return null;
    }
    
    private final void setCurrentDefaultLocale() {
    }
}