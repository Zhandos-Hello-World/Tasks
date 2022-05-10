package com.zhandos.todolist.feature_note.data.repository

import androidx.lifecycle.LiveData
import com.zhandos.todolist.feature_note.data.data_source.NoteDao
import com.zhandos.todolist.feature_note.domain.model.Note
import com.zhandos.todolist.feature_note.domain.repository.NoteRepository

class NoteRepositoryImpl(private val dao: NoteDao) : NoteRepository {

    override fun getAll(): LiveData<List<Note>> {
        return dao.getAll()
    }

    override suspend fun delete(note: Note) {
        dao.delete(note)
    }

    override suspend fun update(note: Note) {
        dao.update(note)
    }

    override suspend fun insert(note: Note) {
        dao.insert(note)
    }
}