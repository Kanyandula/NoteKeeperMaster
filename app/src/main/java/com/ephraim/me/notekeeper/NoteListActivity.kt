package com.ephraim.me.notekeeper

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ephraim.me.takenotes.com.ephraim.me.notekeeper.DataManager
import com.ephraim.me.takenotes.com.ephraim.me.notekeeper.NoteInfo

import kotlinx.android.synthetic.main.activity_note_list.*
import kotlinx.android.synthetic.main.content_note_list.*

class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
           val activityIntent = Intent( this, MainActivity:: class.java)
            startActivity(activityIntent)
        }
        listItems.layoutManager = LinearLayoutManager(this)
        listItems.adapter = NoteRecyclerAdapter(this, DataManager.notes)


    }
    override fun onResume() {
        super.onResume()
        listItems.adapter?.notifyDataSetChanged()
    }


}
