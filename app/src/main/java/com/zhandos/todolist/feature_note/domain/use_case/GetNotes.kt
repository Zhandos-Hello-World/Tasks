package com.zhandos.todolist.feature_note.domain.use_case

import androidx.lifecycle.LiveData
import com.zhandos.todolist.feature_note.domain.model.Note
import com.zhandos.todolist.feature_note.domain.repository.NoteRepository

class GetNotes(
    private val repository: NoteRepository
) {
    operator fun invoke(): LiveData<List<Note>> {
        return repository.getAll()
    }
}