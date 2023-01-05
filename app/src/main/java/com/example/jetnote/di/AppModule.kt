package com.example.jetnote.di

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Room
import com.example.jetnote.data.NoteDatabase
import com.example.jetnote.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@RequiresApi(Build.VERSION_CODES.O)
@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) :NoteDatabase=
        Room.databaseBuilder(
            context, NoteDatabase::class.java,
            "NOTE_DATABASE"
        ).build()

    @Singleton
    @Provides
    fun provideRunDao(noteDatabase: NoteDatabase): NoteDatabaseDao = noteDatabase.noteDao()
}