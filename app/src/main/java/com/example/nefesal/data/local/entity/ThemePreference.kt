package com.example.nefesal.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "theme_preferences")
data class ThemePreference(
    @PrimaryKey val id: Int = 1,
    val isDarkTheme: Boolean
) 