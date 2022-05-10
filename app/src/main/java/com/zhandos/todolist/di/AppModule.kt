package com.zhandos.todolist.di

import android.app.Application
import androidx.room.Room
import com.zhandos.todolist.feature_note.data.data_source.NoteDatabase
import com.zhandos.todolist.feature_note.data.repository.NoteRepositoryImpl
import com.zhandos.todolist.feature_note.domain.repository.NoteRepository
import com.zhandos.todolist.feature_note.domain.use_case.AddNote
import com.zhandos.todolist.feature_note.domain.use_case.DeleteNote
import com.zhandos.todolist.feature_note.domain.use_case.GetNotes
import com.zhandos.todolist.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            "NoteDB"
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            AddNote(repository),
            DeleteNote(repository),
            GetNotes(repository)
        )
    }
}