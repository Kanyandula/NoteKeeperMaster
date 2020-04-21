package com.ephraim.me.notekeeper.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.ephraim.me.notekeeper.NoteRecyclerAdapter
import com.ephraim.me.notekeeper.R
import com.ephraim.me.takenotes.com.ephraim.me.notekeeper.DataManager

class NotesFragment : Fragment() {

    private lateinit var courseViewModel: CourseViewModel
    private lateinit var listItem : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_notes, container, false)
        listItem = root.findViewById(R.id.listItems)

        displayNotes()
        return root
    }

    private fun displayNotes() {
        listItem.layoutManager = LinearLayoutManager(parentFragment?.context)
        listItem.adapter = NoteRecyclerAdapter(requireContext(),  DataManager.notes)
    }
}
