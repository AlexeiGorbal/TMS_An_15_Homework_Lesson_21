package com.example.tms_an_15_homework_lesson_21

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

sealed class BaseNoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val title = view.findViewById<AppCompatTextView>(R.id.title)
    private val text = view.findViewById<AppCompatTextView>(R.id.text)
    private val date = view.findViewById<AppCompatTextView>(R.id.data)

    private val formatter = SimpleDateFormat("hh:mm dd.MM.yyyy")

    fun bind(note: BaseNote, onItemClick: (BaseNote) -> Unit) {
        title.text = note.title
        text.text = note.text
        date.text = formatter.format(note.date)
        itemView.setOnClickListener {
            onItemClick(note)
        }
    }
}