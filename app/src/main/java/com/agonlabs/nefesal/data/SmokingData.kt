package com.agonlabs.nefesal.data

data class SmokingData(
    val cigarettesPerDay: Int,
    val pricePerPack: Double,
    val minutesPerCigarette: Int  // Bir sigarayı içmek için harcanan dakika
) {
    val pricePerCigarette: Double
        get() = pricePerPack / 20.0
} 