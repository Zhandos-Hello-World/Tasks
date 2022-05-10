package com.zhandos.todolist.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val title: String = "",
    val description: String = "",
    val date: Long = 0
)