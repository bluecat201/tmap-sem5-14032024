package com.example.sem5_14032024

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

const val REQUEST_ADD_NOTE = 1
data class Note(val title: String, val text: String)
class MainActivity : AppCompatActivity(), NoteAdapter.OnNoteClickListener {
    val notes = mutableListOf<Note>()
    private var recyclerView: RecyclerView? = null
    private var adapter: NoteAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = NoteAdapter(notes, this)

        val layoutManager = LinearLayoutManager(this)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        recyclerView?.adapter = adapter
    }

    fun fabClick(view: View) {
        val intent = Intent(this, NewNote::class.java)
        startActivityForResult(intent, REQUEST_ADD_NOTE)
    }

    override fun onNoteClick(note: Note) {
        val intent = Intent(this, NoteDetailActivity::class.java)
        intent.putExtra("NOTE_TITLE", note.title)
        intent.putExtra("NOTE_CONTENT", note.text)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_ADD_NOTE && resultCode == RESULT_OK) {
            val noteTitle = data?.getStringExtra("NOTE_TITLE")
            val noteContent = data?.getStringExtra("NOTE_CONTENT")
            if (noteTitle != null && noteContent != null) {
                val newNote = Note(noteTitle, noteContent)
                notes.add(newNote)
                adapter?.notifyItemInserted(notes.size - 1)
            }
        }
    }
}