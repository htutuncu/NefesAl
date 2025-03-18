package com.agonlabs.nefesal.util;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.*;
import com.agonlabs.nefesal.data.SmokingData;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.flow.Flow;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.inject.Inject;
import javax.inject.Singleton;
import android.content.res.Configuration;
import java.util.Locale;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\'\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001a\"\u00020\u0001\u00a2\u0006\u0002\u0010\u001bJ\u0011\u0010\u001c\u001a\u00020\u001dH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0011\u0010\u001f\u001a\u00020\u001dH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0019\u0010 \u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J\u0019\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'J\u0019\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u0013H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000bR\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2 = {"Lcom/agonlabs/nefesal/util/PreferencesManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "isDarkMode", "Lkotlinx/coroutines/flow/Flow;", "", "()Lkotlinx/coroutines/flow/Flow;", "language", "", "getLanguage", "quitDate", "Ljava/time/LocalDateTime;", "getQuitDate", "smokingData", "Lcom/agonlabs/nefesal/data/SmokingData;", "getSmokingData", "smokingDataStore", "localizedStringResource", "id", "", "args", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "resetQuitDate", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetSmokingData", "setDarkMode", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setLanguage", "languageCode", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setQuitDate", "date", "(Ljava/time/LocalDateTime;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSmokingData", "data", "(Lcom/agonlabs/nefesal/data/SmokingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"})
public final class PreferencesManager {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> dataStore = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<androidx.datastore.preferences.core.Preferences> smokingDataStore = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.Boolean> isDarkMode = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.time.LocalDateTime> quitDate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.String> language = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.agonlabs.nefesal.data.SmokingData> smokingData = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> IS_DARK_MODE = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Long> QUIT_DATE = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> LANGUAGE = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Integer> CIGARETTES_PER_DAY = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Double> PRICE_PER_PACK = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Integer> MINUTES_PER_CIGARETTE = null;
    @org.jetbrains.annotations.NotNull
    public static final com.agonlabs.nefesal.util.PreferencesManager.Companion Companion = null;
    
    @javax.inject.Inject
    public PreferencesManager(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> isDarkMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.time.LocalDateTime> getQuitDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getLanguage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.agonlabs.nefesal.data.SmokingData> getSmokingData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setDarkMode(boolean isDarkMode, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setQuitDate(@org.jetbrains.annotations.NotNull
    java.time.LocalDateTime date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object resetQuitDate(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setLanguage(@org.jetbrains.annotations.NotNull
    java.lang.String languageCode, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setSmokingData(@org.jetbrains.annotations.NotNull
    com.agonlabs.nefesal.data.SmokingData data, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object resetSmokingData(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String localizedStringResource(int id, @org.jetbrains.annotations.NotNull
    java.lang.Object... args) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/agonlabs/nefesal/util/PreferencesManager$Companion;", "", "()V", "CIGARETTES_PER_DAY", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "IS_DARK_MODE", "", "LANGUAGE", "", "MINUTES_PER_CIGARETTE", "PRICE_PER_PACK", "", "QUIT_DATE", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}