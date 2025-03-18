package com.agonlabs.nefesal.ui.screens.home;

import androidx.lifecycle.ViewModel;
import com.agonlabs.nefesal.data.SmokingData;
import com.agonlabs.nefesal.util.PreferencesManager;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import java.time.LocalDateTime;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\'\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0018\"\u00020\u0019\u00a2\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\tJ\u001e\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0016J\u0006\u0010%\u001a\u00020\u001cR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e\u00a8\u0006&"}, d2 = {"Lcom/agonlabs/nefesal/ui/screens/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "preferencesManager", "Lcom/agonlabs/nefesal/util/PreferencesManager;", "(Lcom/agonlabs/nefesal/util/PreferencesManager;)V", "_isDarkMode", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_quitDate", "Ljava/time/LocalDateTime;", "_smokingData", "Lcom/agonlabs/nefesal/data/SmokingData;", "isDarkMode", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "quitDate", "getQuitDate", "smokingData", "getSmokingData", "getLocalizedString", "", "id", "", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "resetQuitDate", "", "resetSmokingData", "setQuitDate", "date", "setSmokingData", "cigarettesPerDay", "pricePerPack", "", "minutesPerCigarette", "toggleDarkMode", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.agonlabs.nefesal.util.PreferencesManager preferencesManager = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isDarkMode = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isDarkMode = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.time.LocalDateTime> _quitDate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.time.LocalDateTime> quitDate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.agonlabs.nefesal.data.SmokingData> _smokingData = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.agonlabs.nefesal.data.SmokingData> smokingData = null;
    
    @javax.inject.Inject
    public HomeViewModel(@org.jetbrains.annotations.NotNull
    com.agonlabs.nefesal.util.PreferencesManager preferencesManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isDarkMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.time.LocalDateTime> getQuitDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.agonlabs.nefesal.data.SmokingData> getSmokingData() {
        return null;
    }
    
    public final void toggleDarkMode() {
    }
    
    public final void setQuitDate(@org.jetbrains.annotations.NotNull
    java.time.LocalDateTime date) {
    }
    
    public final void resetQuitDate() {
    }
    
    public final void resetSmokingData() {
    }
    
    public final void setSmokingData(int cigarettesPerDay, double pricePerPack, int minutesPerCigarette) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocalizedString(int id, @org.jetbrains.annotations.NotNull
    java.lang.Object... args) {
        return null;
    }
}