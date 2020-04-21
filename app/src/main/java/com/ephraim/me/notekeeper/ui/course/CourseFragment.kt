package com.ephraim.me.notekeeper.ui.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ephraim.me.notekeeper.CourseRecyclerAdapter
import com.ephraim.me.notekeeper.R
import com.ephraim.me.takenotes.com.ephraim.me.notekeeper.DataManager

class CourseFragment : Fragment() {

    private lateinit var courseViewModel: CourseViewModel
    private lateinit var listItem : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

            ViewModelProviders.of(this).get(CourseViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_course, container, false)
        listItem = root.findViewById(R.id.listItems)

        displayCourses()
        return root
    }

    private fun displayCourses() {
        listItem.layoutManager = GridLayoutManager(parentFragment?.context, 2)
        listItem.adapter = CourseRecyclerAdapter(requireContext(), DataManager.courses.values.toList())
    }
}
