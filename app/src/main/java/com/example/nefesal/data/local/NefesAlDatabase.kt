package com.example.nefesal.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nefesal.data.local.dao.ThemePreferenceDao
import com.example.nefesal.data.local.entity.ThemePreference

@Database(
    entities = [ThemePreference::class],
    version = 1
)
abstract class NefesAlDatabase : RoomDatabase() {
    abstract fun themePreferenceDao(): ThemePreferenceDao
} 