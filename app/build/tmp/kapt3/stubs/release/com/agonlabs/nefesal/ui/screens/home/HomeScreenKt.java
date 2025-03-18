package com.agonlabs.nefesal.ui.screens.home;

import android.annotation.SuppressLint;
import android.os.Build;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.tooling.preview.Preview;
import androidx.compose.ui.unit.Dp;
import com.agonlabs.nefesal.R;
import com.agonlabs.nefesal.data.SmokingData;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.graphics.vector.ImageVector;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import androidx.compose.ui.layout.ContentScale;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000~\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\u0012\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a\b\u0010\n\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0004H\u0007\u001a&\u0010\r\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0007\u001ac\u0010\u0013\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062K\u0010\u0014\u001aG\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00010\u0015H\u0007\u001a.\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007\u001a7\u0010%\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\'H\u0007\u001a3\u0010(\u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b-\u0010.\u001a\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u00100\u001a\u000201H\u0003\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"DatePickerModal", "", "onDateSelected", "Lkotlin/Function1;", "Ljava/time/LocalDateTime;", "onDismiss", "Lkotlin/Function0;", "HomeScreen", "viewModel", "Lcom/agonlabs/nefesal/ui/screens/home/HomeViewModel;", "Preview", "SmokeFreeTimer", "quitDate", "SmokingStats", "smokingData", "Lcom/agonlabs/nefesal/data/SmokingData;", "timeUnits", "", "Lcom/agonlabs/nefesal/ui/screens/home/TimeUnitData;", "SmokingStatsDialog", "onConfirm", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "cigarettesPerDay", "", "pricePerPack", "minutesPerCigarette", "StatItemNew", "value", "", "label", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TimePickerDialog", "content", "Landroidx/compose/runtime/Composable;", "VerticalDivider", "color", "Landroidx/compose/ui/graphics/Color;", "thickness", "Landroidx/compose/ui/unit/Dp;", "VerticalDivider-Hht5A8o", "(Landroidx/compose/ui/Modifier;JF)V", "calculateTime", "duration", "Ljava/time/Duration;", "app_release"})
public final class HomeScreenKt {
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @android.annotation.SuppressLint(value = {"UnusedMaterial3ScaffoldPaddingParameter"})
    @androidx.compose.runtime.Composable
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull
    com.agonlabs.nefesal.ui.screens.home.HomeViewModel viewModel) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @androidx.compose.runtime.Composable
    private static final java.util.List<com.agonlabs.nefesal.ui.screens.home.TimeUnitData> calculateTime(java.time.Duration duration) {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @androidx.compose.runtime.Composable
    public static final void SmokeFreeTimer(@org.jetbrains.annotations.NotNull
    java.time.LocalDateTime quitDate) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void DatePickerModal(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.time.LocalDateTime, kotlin.Unit> onDateSelected, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void TimePickerDialog(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onConfirm, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> content) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SmokingStatsDialog(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Double, ? super java.lang.Integer, kotlin.Unit> onConfirm) {
    }
    
    @android.annotation.SuppressLint(value = {"DefaultLocale"})
    @androidx.compose.runtime.Composable
    public static final void SmokingStats(@org.jetbrains.annotations.NotNull
    java.time.LocalDateTime quitDate, @org.jetbrains.annotations.NotNull
    com.agonlabs.nefesal.data.SmokingData smokingData, @org.jetbrains.annotations.NotNull
    java.util.List<com.agonlabs.nefesal.ui.screens.home.TimeUnitData> timeUnits) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void StatItemNew(@org.jetbrains.annotations.NotNull
    java.lang.String value, @org.jetbrains.annotations.NotNull
    java.lang.String label, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.Nullable
    androidx.compose.ui.graphics.vector.ImageVector icon) {
    }
    
    @android.annotation.SuppressLint(value = {"UnusedMaterial3ScaffoldPaddingParameter"})
    @androidx.compose.ui.tooling.preview.Preview
    @androidx.compose.runtime.Composable
    public static final void Preview() {
    }
}