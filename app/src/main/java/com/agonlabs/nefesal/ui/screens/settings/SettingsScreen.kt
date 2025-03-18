package com.agonlabs.nefesal.ui.screens.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.agonlabs.nefesal.R
import com.agonlabs.nefesal.util.localizedStringResource
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.agonlabs.nefesal.data.PolicyType
import com.agonlabs.nefesal.navigation.Screen
import com.agonlabs.nefesal.ui.screens.home.HomeViewModel
import com.agonlabs.nefesal.ui.theme.loraFamily
import com.agonlabs.nefesal.util.BaseBottomSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel(),
    homeViewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {
    val showLanguageDialog = remember { mutableStateOf(false) }
    val selectedLanguage by viewModel.selectedLanguage.collectAsState()
    val isDarkMode by viewModel.isDarkMode.collectAsState()

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    var showResetBottomSheet by remember { mutableStateOf(false) }

//    if (selectedLanguage != "tr" && selectedLanguage != "en") {
//        viewModel.setLanguage("en")
//    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Image(
            painter = if (isDarkMode) painterResource(id = R.drawable.bg_dark) else painterResource(id = R.drawable.bg_light),
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
                text = localizedStringResource(R.string.settings),
                fontFamily = loraFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(top = 18.dp, bottom = 8.dp, start = 8.dp)
            )

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
                        .padding(horizontal = 16.dp, vertical = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = localizedStringResource(R.string.dark_mode),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Switch(
                        checked = isDarkMode,
                        onCheckedChange = { viewModel.toggleDarkMode() },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = MaterialTheme.colorScheme.primary,
                            checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                            uncheckedThumbColor = MaterialTheme.colorScheme.outline,
                            uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    )
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { showLanguageDialog.value = true },
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = localizedStringResource(R.string.language),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Icon(
                        painter = painterResource(
                            id = when (selectedLanguage) {
                                "tr" -> R.drawable.ic_flag_tr
                                "en" -> R.drawable.ic_flag_en
                                else -> R.drawable.ic_flag_en // Default to Turkish
                            }
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp),
                        tint = Color.Unspecified
                    )
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
                onClick = {
                    showResetBottomSheet = true
                }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 26.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = localizedStringResource(R.string.reset),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
                onClick = {
                    navController.navigate(Screen.Policies.createRoute(PolicyType.PRIVACY_POLICY))
                }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 26.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = localizedStringResource(id = R.string.privacy_policy),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
                onClick = {
                    navController.navigate(Screen.Policies.createRoute(PolicyType.TERMS_OF_USE))
                }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 26.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = localizedStringResource(id = R.string.terms_of_use),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    }

    if (showLanguageDialog.value) {
        LanguageSelectionDialog(
            selectedLanguage = selectedLanguage,
            onLanguageSelected = { languageCode ->
                viewModel.setLanguage(languageCode)
                showLanguageDialog.value = false
            },
            onDismiss = { showLanguageDialog.value = false }
        )
    }

    if (showResetBottomSheet) {
        BaseBottomSheet(
            primaryButtonText = localizedStringResource(id = R.string.yes),
            secondaryButtonText = localizedStringResource(id = R.string.no),
            headerText = localizedStringResource(id = R.string.are_you_sure_reset),
            onDismiss = { showResetBottomSheet = false },
            onPrimaryAction = {
                homeViewModel.resetQuitDate()
                homeViewModel.resetSmokingData()
                showResetBottomSheet = false
            },
            onSecondaryAction = {
                showResetBottomSheet = false
            }
        )
    }
}

@Composable
fun SettingsItem(
    title: String,
    subtitle: String? = null,
    onClick: (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .then(if (onClick != null) Modifier.clickable { onClick() } else Modifier),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )
                if (subtitle != null) {
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            trailing?.invoke()
        }
    }
}

@Composable
fun LanguageSelectionDialog(
    selectedLanguage: String?,
    onLanguageSelected: (String?) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(localizedStringResource(R.string.language)) },
        text = {
            Column {
                DialogOption(
                    text = localizedStringResource(R.string.language_turkish),
                    selected = selectedLanguage == "tr",
                    onClick = { onLanguageSelected("tr") },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_flag_tr),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = Color.Unspecified
                        )
                    }
                )
                DialogOption(
                    text = localizedStringResource(R.string.language_english),
                    selected = selectedLanguage == "en",
                    onClick = { onLanguageSelected("en") },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_flag_en),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = Color.Unspecified
                        )
                    }
                )
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(localizedStringResource(R.string.ok))
            }
        }
    )
}

@Composable
fun DialogOption(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick
        )
        Spacer(modifier = Modifier.width(8.dp))
        icon()
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}
