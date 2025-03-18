package com.agonlabs.nefesal;

import android.app.Application;
import com.agonlabs.nefesal.util.LocaleHelper;
import com.agonlabs.nefesal.util.PreferencesManager;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import dagger.hilt.android.HiltAndroidApp;
import javax.inject.Inject;

@dagger.hilt.android.HiltAndroidApp
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/agonlabs/nefesal/NefesAlApplication;", "Landroid/app/Application;", "()V", "preferencesManager", "Lcom/agonlabs/nefesal/util/PreferencesManager;", "getPreferencesManager", "()Lcom/agonlabs/nefesal/util/PreferencesManager;", "setPreferencesManager", "(Lcom/agonlabs/nefesal/util/PreferencesManager;)V", "onCreate", "", "app_release"})
public final class NefesAlApplication extends android.app.Application {
    @javax.inject.Inject
    public com.agonlabs.nefesal.util.PreferencesManager preferencesManager;
    
    public NefesAlApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.agonlabs.nefesal.util.PreferencesManager getPreferencesManager() {
        return null;
    }
    
    public final void setPreferencesManager(@org.jetbrains.annotations.NotNull
    com.agonlabs.nefesal.util.PreferencesManager p0) {
    }
    
    @java.lang.Override
    public void onCreate() {
    }
}