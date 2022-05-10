package com.zhandos.todolist.feature_note.domain.use_case

import com.zhandos.todolist.feature_note.domain.model.Note
import com.zhandos.todolist.feature_note.domain.repository.NoteRepository

class AddNote(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        repository.insert(note)
    }
}