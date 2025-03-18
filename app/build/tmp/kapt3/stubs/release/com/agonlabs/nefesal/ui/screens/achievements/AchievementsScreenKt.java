package com.agonlabs.nefesal.ui.screens.achievements;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.text.font.FontWeight;
import com.agonlabs.nefesal.R;
import com.agonlabs.nefesal.ui.screens.home.HomeViewModel;
import androidx.compose.foundation.layout.*;
import androidx.compose.material3.CardDefaults;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.Stroke;
import com.agonlabs.nefesal.data.AchievementItem;
import java.time.Duration;
import java.time.LocalDateTime;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u0016\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007\u001a\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0007\u00a8\u0006\u000f"}, d2 = {"AchievementsScreen", "", "homeViewModel", "Lcom/agonlabs/nefesal/ui/screens/home/HomeViewModel;", "CircularProgressBar", "percentage", "", "ScrollableItemList", "itemList", "", "Lcom/agonlabs/nefesal/data/AchievementItem;", "calculateProgress", "quitDate", "Ljava/time/LocalDateTime;", "targetMinutes", "app_release"})
public final class AchievementsScreenKt {
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @androidx.compose.runtime.Composable
    public static final void AchievementsScreen(@org.jetbrains.annotations.NotNull
    com.agonlabs.nefesal.ui.screens.home.HomeViewModel homeViewModel) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public static final int calculateProgress(@org.jetbrains.annotations.Nullable
    java.time.LocalDateTime quitDate, int targetMinutes) {
        return 0;
    }
    
    @androidx.compose.runtime.Composable
    public static final void ScrollableItemList(@org.jetbrains.annotations.NotNull
    java.util.List<com.agonlabs.nefesal.data.AchievementItem> itemList) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void CircularProgressBar(int percentage) {
    }
}