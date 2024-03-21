package com.example.sem5_14032024

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NewNote : AppCompatActivity() {
    private lateinit var editTextNoteTitle: EditText
    private lateinit var editTextNoteContent: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(getString(R.string.new_note))
        setContentView(R.layout.new_node)

        editTextNoteTitle = findViewById(R.id.editTextNoteTitle)
        editTextNoteContent = findViewById(R.id.editTextNoteContent)

        val buttonAddNote = findViewById<Button>(R.id.buttonAddNote)
        buttonAddNote.setOnClickListener { onClick(it) }
    }

    fun onClick(view: View) {
        val noteTitle = editTextNoteTitle.text.toString()
        val noteContent = editTextNoteContent.text.toString()

        val intent = Intent()
        intent.putExtra("NOTE_TITLE", noteTitle)
        intent.putExtra("NOTE_CONTENT", noteContent)
        setResult(RESULT_OK, intent)
        finish()
    }
}