package com.example.tms_an_15_homework_lesson_21

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NoteListFragment : Fragment(R.layout.fragment_note_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycle = view.findViewById<RecyclerView>(R.id.recycler)
        recycle.layoutManager = LinearLayoutManager(context)

        val adapter = NoteAdapter {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, it.title + "\n" + it.text)
            val chooser = Intent.createChooser(intent, null)
            try {
                startActivity(chooser)
            } catch (e: ActivityNotFoundException) {
                // Define what your app should do if no activity can handle the intent.
            }
        }

        recycle.adapter = adapter

        setFragmentResultListener("result"){requestKey, bundle ->
            val note = (bundle.getParcelable("note")as? Note)
                ?: (bundle.getParcelable("important_note")as? ImportantNote)
            if (note != null) {
                adapter.addNote(note)
            }

        }

    }

    companion object {

        fun newInstance() = NoteListFragment()
    }

}