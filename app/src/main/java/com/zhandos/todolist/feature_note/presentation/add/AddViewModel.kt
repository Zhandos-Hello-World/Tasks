package com.zhandos.todolist.feature_note.presentation.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhandos.todolist.feature_note.domain.model.Note
import com.zhandos.todolist.feature_note.domain.use_case.NoteUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddViewModel @Inject constructor(private val useCases: NoteUseCases) : ViewModel() {
    val all = useCases.getNotes()


    val title = MutableLiveData("")
    val description = MutableLiveData("")


    fun submit() {
        viewModelScope.launch {
            useCases.addNote(
                Note(
                    title = title.value ?: "Unknown",
                    description = description.value ?: "Unknown",
                    date = System.currentTimeMillis()
                )
            )
        }
    }
}