package com.example.nefesal.ui.screens.achievements

import android.annotation.SuppressLint
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
import com.example.nefesal.R
import com.example.nefesal.ui.screens.home.HomeViewModel
import com.example.nefesal.ui.theme.loraFamily
import com.example.nefesal.util.localizedStringResource
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import com.example.nefesal.data.AchievementItem
import com.example.nefesal.ui.theme.Green50
import com.example.nefesal.util.loadLocalizedSmokingBenefits
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun AchievementsScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val isDarkMode by homeViewModel.isDarkMode.collectAsState()
    val context = LocalContext.current
    val benefitsArray = loadLocalizedSmokingBenefits(context)

    val itemNewList = arrayListOf<AchievementItem>()
    benefitsArray.forEachIndexed { index, item ->
        itemNewList.add(AchievementItem(index, 95 + index, item.text))
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

            ScrollableItemList(itemList = itemNewList)
        }
    }
}

class ListItemState(item: AchievementItem) {
    var item by mutableStateOf(item)
}

fun updatePercentage(itemState: ListItemState) {
    itemState.item = itemState.item.copy(percentage = Random.nextInt(0, 101))
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ScrollableItemList(itemList: List<AchievementItem>) {
    val itemStates = itemList.map { remember { ListItemState(it) } }
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(modifier = Modifier) {
        items(itemStates) { itemState ->
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
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ) {
                        CircularProgressBar(
                            percentage = itemState.item.percentage
                        )
                    }

                    Text(
                        text = itemState.item.text,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }

    // Saatte bir yüzde değerlerini güncelle
    rememberCoroutineScope().launch {
        while (true) {
            delay(60000) // 1 saat = 3600000 milisaniye
            itemStates.forEach { updatePercentage(it) }
        }
    }
}

@Composable
fun CircularProgressBar(percentage: Int) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(50.dp)
    ) {
        Canvas(modifier = Modifier.size(50.dp)) {
            val sweepAngle = (percentage / 100f) * 360f
            drawArc(
                color = Green50,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(text = "$percentage%", fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}