package com.zhandos.todolist.feature_note.presentation.common

import androidx.lifecycle.ViewModel
import com.zhandos.todolist.feature_note.domain.use_case.NoteUseCases
import javax.inject.Inject

class CommonViewModel @Inject constructor(private val noteUseCases: NoteUseCases) : ViewModel() {
    val all = noteUseCases.getNotes()
}