package com.zhandos.todolist.feature_note.data.data_source

import androidx.lifecycle.LiveData
import androidx.room.*
import com.zhandos.todolist.feature_note.domain.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM Note")
    fun getAll(): LiveData<List<Note>>


    @Delete
    suspend fun delete(note: Note)


    @Update
    suspend fun update(note: Note)

    @Insert
    suspend fun insert(note: Note)
}