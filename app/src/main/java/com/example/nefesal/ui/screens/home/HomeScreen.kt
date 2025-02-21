package com.example.nefesal.ui.screens.home

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nefesal.R
import com.example.nefesal.data.SmokingData
import com.example.nefesal.util.localizedStringResource
import androidx.compose.ui.text.input.KeyboardType
import java.text.NumberFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nefesal.ui.theme.loraFamily
import kotlinx.coroutines.delay
import java.time.Duration
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Calendar
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    var showDatePicker by remember { mutableStateOf(false) }
    val quitDate by viewModel.quitDate.collectAsState()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            AnimatedVisibility(
                visible = quitDate == null,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Text(
                    text = localizedStringResource(R.string.welcome),
                    fontFamily = loraFamily,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    textAlign = TextAlign.Center
                )
            }

            if (quitDate == null) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Sigarayı bırakmaya karar verdiğiniz ve sağlıklı yaşamayı tercih ettiğiniz için tebrik ederiz.",
                        fontFamily = loraFamily,
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        onClick = { showDatePicker = true },
                        modifier = Modifier.padding(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text(text = "Bırakma tarihinizi seçiniz")
                    }
                }
            } else {
                SmokeFreeTimer(quitDate = quitDate!!)
            }

            if (showDatePicker) {
                DatePickerModal(
                    onDateSelected = { selectedDateTime ->
                        selectedDateTime?.let {
                            viewModel.setQuitDate(it)
                        }
                        showDatePicker = false
                    },
                    onDismiss = {
                        showDatePicker = false
                    }
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SmokeFreeTimer(quitDate: LocalDateTime) {
    val currentTime = remember { mutableStateOf(LocalDateTime.now()) }
    val viewModel: HomeViewModel = hiltViewModel()
    val smokingData by viewModel.smokingData.collectAsState()
    var showSmokingStatsDialog by remember { mutableStateOf(false) }
    
    LaunchedEffect(Unit) {
        while(true) {
            currentTime.value = LocalDateTime.now()
            delay(60000)
        }
    }

    val duration = Duration.between(quitDate, currentTime.value)
    val years = duration.toDays() / 365
    val remainingDaysAfterYears = duration.toDays() % 365
    val months = remainingDaysAfterYears / 30
    val days = remainingDaysAfterYears % 30
    val hours = duration.toHours() % 24

    val timeUnits = listOf(
        TimeUnitData(localizedStringResource(R.string.year), years),
        TimeUnitData(localizedStringResource(R.string.month), months),
        TimeUnitData(localizedStringResource(R.string.day), days),
        TimeUnitData(localizedStringResource(R.string.hour), hours)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
             // Yükseklik arttı
            .padding(horizontal = 16.dp)
    ) {
        items(timeUnits) { timeUnit ->
            TimeUnitCard(timeUnit)
        }
    }

    Spacer(modifier = Modifier.height(44.dp))

    // Sigara istatistikleri kartı (eğer veriler girilmişse)
    if (smokingData != null) {
        SmokingStats(quitDate = quitDate, smokingData = smokingData!!)
    }

    //Spacer(modifier = Modifier.weight(1f))

    // Bırakma tarihi kartı
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${localizedStringResource(R.string.quit_date)}:\n${quitDate.format(
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))}",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Sigara istatistiklerini girmek/güncellemek için buton
            Button(
                onClick = { showSmokingStatsDialog = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = if (smokingData == null) 
                        localizedStringResource(R.string.enter_smoking_stats)
                    else 
                        localizedStringResource(R.string.update_smoking_stats)
                )
            }
        }
    }

    if (showSmokingStatsDialog) {
        SmokingStatsDialog(
            onDismiss = { showSmokingStatsDialog = false },
            onConfirm = { cigarettesPerDay, pricePerPack, minutesPerCigarette ->
                viewModel.setSmokingData(cigarettesPerDay, pricePerPack, minutesPerCigarette)
                showSmokingStatsDialog = false
            }
        )
    }
}

data class TimeUnitData(
    val label: String,
    val value: Long
)

@Composable
fun TimeUnitCard(timeUnit: TimeUnitData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.5f),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = timeUnit.value.toString(),
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontFamily = loraFamily
                ),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = timeUnit.label,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontFamily = loraFamily
                ),
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f),
                textAlign = TextAlign.Center
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDateSelected: (LocalDateTime?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()
    var showDatePicker by remember { mutableStateOf(true) }
    var showTimePicker by remember { mutableStateOf(false) }
    var tempDate by remember { mutableStateOf<LocalDate?>(null) }

    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = onDismiss,
            confirmButton = {
                TextButton(onClick = {
                    datePickerState.selectedDateMillis?.let { millis ->
                        tempDate = Instant.ofEpochMilli(millis)
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate()
                        showTimePicker = true // Saat seçimini aç
                        showDatePicker = false
                    }
                }) {
                    Text(localizedStringResource(R.string.next))
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text(localizedStringResource(R.string.cancel))
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }


    LaunchedEffect(showDatePicker) {
        if (!showDatePicker) {
            delay(300) // Küçük bir gecikme ile açılmasını sağla
            showTimePicker = true
        }
    }

    // Saat Seçimi Dialog'u
    if (showTimePicker) {
        val currentTime = Calendar.getInstance()
        val timePickerState = rememberTimePickerState(
            initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
            initialMinute = currentTime.get(Calendar.MINUTE),
            is24Hour = true
        )

        TimePickerDialog(
            onDismiss = { showTimePicker = false },
            onConfirm = {
                tempDate?.let { date ->
                    val selectedDateTime = LocalDateTime.of(
                        date,
                        LocalTime.of(timePickerState.hour, timePickerState.minute)
                    )
                    onDateSelected(selectedDateTime)
                }
                onDismiss()
            }
        ) {
            TimeInput(state = timePickerState)
        }
    }
}

@Composable
fun TimePickerDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    content: @Composable () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(localizedStringResource(R.string.dismiss))
            }
        },
        confirmButton = {
            TextButton(onClick = { onConfirm() }) {
                Text(localizedStringResource(R.string.ok))
            }
        },
        text = { content() }
    )
}

@Composable
fun SmokingStatsDialog(
    onDismiss: () -> Unit,
    onConfirm: (cigarettesPerDay: Int, pricePerPack: Double, minutesPerCigarette: Int) -> Unit
) {
    var cigarettesPerDay by remember { mutableStateOf("") }
    var pricePerPack by remember { mutableStateOf("") }
    var minutesPerCigarette by remember { mutableStateOf("") }
    var hasError by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(localizedStringResource(R.string.smoking_stats_title)) },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                OutlinedTextField(
                    value = cigarettesPerDay,
                    onValueChange = { cigarettesPerDay = it },
                    label = { Text(localizedStringResource(R.string.cigarettes_per_day)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    isError = hasError && cigarettesPerDay.isEmpty(),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = pricePerPack,
                    onValueChange = { pricePerPack = it },
                    label = { Text(localizedStringResource(R.string.price_per_pack)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    isError = hasError && pricePerPack.isEmpty(),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = minutesPerCigarette,
                    onValueChange = { minutesPerCigarette = it },
                    label = { Text(localizedStringResource(R.string.minutes_per_cigarette)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    isError = hasError && minutesPerCigarette.isEmpty(),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    hasError = cigarettesPerDay.isEmpty() || 
                             pricePerPack.isEmpty() || 
                             minutesPerCigarette.isEmpty()
                    if (!hasError) {
                        onConfirm(
                            cigarettesPerDay.toIntOrNull() ?: 0,
                            pricePerPack.toDoubleOrNull() ?: 0.0,
                            minutesPerCigarette.toIntOrNull() ?: 0
                        )
                    }
                }
            ) {
                Text(localizedStringResource(R.string.save))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(localizedStringResource(R.string.cancel))
            }
        }
    )
}

@Composable
fun SmokingStats(
    quitDate: LocalDateTime,
    smokingData: SmokingData
) {
    val currentTime = remember { mutableStateOf(LocalDateTime.now()) }
    val viewModel: HomeViewModel = hiltViewModel()
    
    LaunchedEffect(Unit) {
        while(true) {
            currentTime.value = LocalDateTime.now()
            delay(1000)
        }
    }

    // Kullanıcının sigarayı bırakma tarihinden itibaren geçen saat sayısı
    val hoursPassed = Duration.between(quitDate, currentTime.value).toHours()

    // Kullanıcının saat başına içtiği sigara sayısı
    val cigarettesPerHour = smokingData.cigarettesPerDay / 24.0
    
    // İçilmeyen toplam sigara sayısı
    val cigarettesNotSmoked = (cigarettesPerHour * hoursPassed).toInt()

    // Bir sigaranın fiyatı
    val pricePerCigarette = smokingData.pricePerPack

    // Kullanıcının biriktirdiği toplam para
    val moneySaved = cigarettesNotSmoked * pricePerCigarette / 20

    // Kurtarılan toplam dakika
    val savedMinutes = cigarettesNotSmoked * smokingData.minutesPerCigarette
    
    // Kurtarılan zamanı gün ve saat olarak formatla
    val savedDays = savedMinutes / (24 * 60)
    val remainingHours = (savedMinutes % (24 * 60)) / 60

    val savedTimeText = when {
        savedDays > 0 -> viewModel.getLocalizedString(
            R.string.time_format_days_hours,
            savedDays,
            remainingHours
        )
        else -> viewModel.getLocalizedString(
            R.string.time_format_hours,
            remainingHours
        )
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = localizedStringResource(R.string.smoking_stats_title),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontFamily = loraFamily,
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // İçilmeyen sigara ve biriken para yan yana
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                StatItemNew(
                    value = cigarettesNotSmoked.toString(),
                    label = localizedStringResource(R.string.cigarettes_not_smoked),
                    modifier = Modifier.weight(1f)
                )
                VerticalDivider(
                    modifier = Modifier
                        .height(60.dp)
                        .padding(horizontal = 16.dp),
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.2f)
                )
                StatItemNew(
                    value = String.format("%.0f ₺", moneySaved),
                    label = localizedStringResource(R.string.money_saved),
                    modifier = Modifier.weight(1f)
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.2f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            
            // Kurtarılan zaman altta
            StatItemNew(
                value = savedTimeText,
                label = localizedStringResource(R.string.time_saved)
            )
        }
    }
}

@Composable
fun StatItemNew(
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(8.dp)
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        
        Text(
            text = value,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = loraFamily
            ),
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        
        Spacer(modifier = Modifier.height(4.dp))
        
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun VerticalDivider(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
    thickness: Dp = 1.dp
) {
    Box(
        modifier = modifier
            .width(thickness)
            .background(color = color)
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun Preview() {
    Scaffold {
    }
}