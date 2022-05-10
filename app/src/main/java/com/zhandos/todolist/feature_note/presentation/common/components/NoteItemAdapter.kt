package com.zhandos.todolist.feature_note.presentation.common.components

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zhandos.todolist.databinding.ItemNoteBinding
import com.zhandos.todolist.feature_note.domain.model.Note

class NoteItemAdapter : ListAdapter<Note, NoteItemAdapter.ItemViewHolder>(NoteItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val note = getItem(position)
        holder.bind(note)
    }

    class ItemViewHolder(private var binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Note) {
            binding.note = item
        }

        companion object {
            fun inflate(parent: ViewGroup): ItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNoteBinding.inflate(layoutInflater, parent, false)
                return ItemViewHolder(binding)
            }
        }
    }
}