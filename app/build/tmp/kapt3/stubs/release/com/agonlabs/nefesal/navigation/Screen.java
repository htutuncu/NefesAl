package com.agonlabs.nefesal.navigation;

import com.agonlabs.nefesal.data.PolicyType;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0005\f\r\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/agonlabs/nefesal/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "Achievements", "Home", "Policies", "Settings", "Splash", "Lcom/agonlabs/nefesal/navigation/Screen$Achievements;", "Lcom/agonlabs/nefesal/navigation/Screen$Home;", "Lcom/agonlabs/nefesal/navigation/Screen$Policies;", "Lcom/agonlabs/nefesal/navigation/Screen$Settings;", "Lcom/agonlabs/nefesal/navigation/Screen$Splash;", "app_release"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/agonlabs/nefesal/navigation/Screen$Achievements;", "Lcom/agonlabs/nefesal/navigation/Screen;", "()V", "app_release"})
    public static final class Achievements extends com.agonlabs.nefesal.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.agonlabs.nefesal.navigation.Screen.Achievements INSTANCE = null;
        
        private Achievements() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/agonlabs/nefesal/navigation/Screen$Home;", "Lcom/agonlabs/nefesal/navigation/Screen;", "()V", "app_release"})
    public static final class Home extends com.agonlabs.nefesal.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.agonlabs.nefesal.navigation.Screen.Home INSTANCE = null;
        
        private Home() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/agonlabs/nefesal/navigation/Screen$Policies;", "Lcom/agonlabs/nefesal/navigation/Screen;", "()V", "createRoute", "", "policyType", "Lcom/agonlabs/nefesal/data/PolicyType;", "app_release"})
    public static final class Policies extends com.agonlabs.nefesal.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.agonlabs.nefesal.navigation.Screen.Policies INSTANCE = null;
        
        private Policies() {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull
        com.agonlabs.nefesal.data.PolicyType policyType) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/agonlabs/nefesal/navigation/Screen$Settings;", "Lcom/agonlabs/nefesal/navigation/Screen;", "()V", "app_release"})
    public static final class Settings extends com.agonlabs.nefesal.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.agonlabs.nefesal.navigation.Screen.Settings INSTANCE = null;
        
        private Settings() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/agonlabs/nefesal/navigation/Screen$Splash;", "Lcom/agonlabs/nefesal/navigation/Screen;", "()V", "app_release"})
    public static final class Splash extends com.agonlabs.nefesal.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.agonlabs.nefesal.navigation.Screen.Splash INSTANCE = null;
        
        private Splash() {
        }
    }
}