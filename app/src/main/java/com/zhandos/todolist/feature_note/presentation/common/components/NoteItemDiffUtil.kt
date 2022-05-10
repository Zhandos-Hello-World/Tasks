package com.zhandos.todolist.feature_note.presentation.common.components

import androidx.recyclerview.widget.DiffUtil
import com.zhandos.todolist.feature_note.domain.model.Note

class NoteItemDiffUtil: DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }
}