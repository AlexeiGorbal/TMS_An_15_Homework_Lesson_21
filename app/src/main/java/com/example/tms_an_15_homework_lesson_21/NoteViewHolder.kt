package com.example.tms_an_15_homework_lesson_21

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class NoteViewHolder(view: View) : BaseNoteViewHolder(view) {
    companion object {

        fun from(parent: ViewGroup): NoteViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_note, parent, false
            )
            return NoteViewHolder(view)
        }
    }
}