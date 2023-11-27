package com.pthw.composebookstore.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.Calendar
import java.util.Locale
import javax.inject.Singleton

/**
 * Created by P.T.H.W on 11/09/2023.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCalendarInstance(): Calendar {
        return Calendar.getInstance(Locale.ENGLISH)
    }
}