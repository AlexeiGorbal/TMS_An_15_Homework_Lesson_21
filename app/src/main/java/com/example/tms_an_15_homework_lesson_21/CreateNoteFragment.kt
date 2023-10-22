package com.example.tms_an_15_homework_lesson_21

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.setFragmentResult
import java.util.Date

class CreateNoteFragment : Fragment(R.layout.fragment_create_note) {

    private var listener: OnNoteCreatedListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = parentFragment as? OnNoteCreatedListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val button = view.findViewById<AppCompatButton>(R.id.button)
        button.setOnClickListener {

            val titleView = view.findViewById<AppCompatEditText>(R.id.title)
            val title = titleView.text.toString()
            val textView = view.findViewById<AppCompatEditText>(R.id.text)
            val text = textView.text.toString()
            val date = Date(System.currentTimeMillis())
            val checkBoxView = view.findViewById<AppCompatCheckBox>(R.id.check_box)
            val important = checkBoxView.isChecked

            if (title.isBlank()) {
                titleView.error = "Empty title"
            }

            if (text.isBlank()) {
                textView.error = "Empty title"
            }

            if (!title.isBlank() && !text.isBlank()) {
                val bundle = Bundle()
                if (important) {
                    bundle.putParcelable("important_note", ImportantNote(title, text, date))
                } else {
                    bundle.putParcelable("note", Note(title, text, date))
                }
                setFragmentResult("result", bundle)
                listener?.onNoteCreated()

                titleView.text=null
                textView.text=null
            }
        }
    }

    interface OnNoteCreatedListener {
        fun onNoteCreated()
    }

    companion object {

        fun newInstance() = CreateNoteFragment()
    }
}