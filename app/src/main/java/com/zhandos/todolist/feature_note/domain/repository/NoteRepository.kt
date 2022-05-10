package com.zhandos.todolist.feature_note.domain.repository

import androidx.lifecycle.LiveData
import com.zhandos.todolist.feature_note.domain.model.Note

interface NoteRepository {

    fun getAll(): LiveData<List<Note>>

    suspend fun delete(note: Note)

    suspend fun update(note: Note)

    suspend fun insert(note: Note)
}