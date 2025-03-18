package com.agonlabs.nefesal.ui.screens.achievements

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.agonlabs.nefesal.R
import com.agonlabs.nefesal.ui.screens.home.HomeViewModel
import com.agonlabs.nefesal.ui.theme.loraFamily
import com.agonlabs.nefesal.util.localizedStringResource
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import com.agonlabs.nefesal.data.AchievementItem
import com.agonlabs.nefesal.util.loadLocalizedSmokingBenefits
import kotlinx.coroutines.delay
import java.time.Duration
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AchievementsScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val isDarkMode by homeViewModel.isDarkMode.collectAsState()
    val context = LocalContext.current
    val benefitsArray = loadLocalizedSmokingBenefits(context)

    val quitDate = homeViewModel.quitDate.collectAsState().value
    val itemNewList = remember(quitDate) {
        benefitsArray.mapIndexed { index, item ->
            val progress = calculateProgress(quitDate, item.time)
            AchievementItem(index, progress, item.text)
        }
    }

    var updatedList by remember { mutableStateOf(itemNewList) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(quitDate) {
        while (true) {
            delay(60000) // 1 dakika
            updatedList = benefitsArray.mapIndexed { index, item ->
                val progress = calculateProgress(quitDate, item.time)
                AchievementItem(index, progress, item.text)
            }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Image(
            painter = if (isDarkMode) painterResource(id = R.drawable.bg_dark) else painterResource(
                id = R.drawable.bg_light
            ),
            contentDescription = "background",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = localizedStringResource(R.string.achievements),
                fontFamily = loraFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(top = 18.dp, bottom = 8.dp, start = 8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            ScrollableItemList(itemList = updatedList)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun calculateProgress(quitDate: LocalDateTime?, targetMinutes: Int): Int {
    if (quitDate == null) return 0

    val elapsedMinutes = Duration.between(quitDate, LocalDateTime.now()).toMinutes()
    return ((elapsedMinutes.toDouble() / targetMinutes) * 100).coerceIn(0.0, 100.0).toInt()
}

@Composable
fun ScrollableItemList(itemList: List<AchievementItem>) {
    LazyColumn(modifier = Modifier) {
        items(itemList) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        CircularProgressBar(percentage = item.percentage)
                    }

                    Text(
                        text = item.text,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun CircularProgressBar(percentage: Int) {
    val colorTheme = MaterialTheme.colorScheme.primary
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(50.dp)
    ) {
        Canvas(modifier = Modifier.size(50.dp)) {
            val sweepAngle = (percentage / 100f) * 360f
            drawArc(
                color = colorTheme,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(text = "$percentage%", fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}
