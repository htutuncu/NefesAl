package com.example.nefesal.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nefesal.data.local.entity.ThemePreference
import kotlinx.coroutines.flow.Flow

@Dao
interface ThemePreferenceDao {
    @Query("SELECT * FROM theme_preferences WHERE id = 1")
    fun getThemePreference(): Flow<ThemePreference?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setThemePreference(preference: ThemePreference)
} 