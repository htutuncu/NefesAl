package com.example.nefesal.di

import android.content.Context
import androidx.room.Room
import com.example.nefesal.data.local.NefesAlDatabase
import com.example.nefesal.data.local.dao.ThemePreferenceDao
import com.example.nefesal.data.repository.ThemePreferenceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): NefesAlDatabase = Room.databaseBuilder(
        context,
        NefesAlDatabase::class.java,
        "nefes_al_db"
    ).build()

    @Provides
    @Singleton
    fun provideThemePreferenceDao(
        database: NefesAlDatabase
    ): ThemePreferenceDao = database.themePreferenceDao()

    @Provides
    @Singleton
    fun provideThemePreferenceRepository(
        dao: ThemePreferenceDao
    ): ThemePreferenceRepository = ThemePreferenceRepository(dao)
} 