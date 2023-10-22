package com.example.tms_an_15_homework_lesson_21

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.fragment.app.commit
import androidx.fragment.app.createViewModelLazy
import androidx.fragment.app.setFragmentResultListener

class MainFragment : Fragment(R.layout.fragment_main),CreateNoteFragment.OnNoteCreatedListener {

    private var button: AppCompatButton? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            childFragmentManager.commit {
                add(R.id.fragment_container, NoteListFragment.newInstance())
            }

            button = view.findViewById(R.id.button)
            button?.setOnClickListener {
                childFragmentManager.commit {
                    add(R.id.fragment_container, CreateNoteFragment.newInstance())
                    addToBackStack(null)
                }
                button?.isVisible = false
            }

        }
    }

    override fun onNoteCreated() {

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            childFragmentManager.popBackStack()
            button?.isVisible = true
        }
    }
}


