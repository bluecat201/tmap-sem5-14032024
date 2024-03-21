package com.example.sem5_14032024

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class NoteDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(getString(R.string.note_detail))
        setContentView(R.layout.activity_note_detail)

        val titleTextView = findViewById<TextView>(R.id.text_title)
        val textTextView = findViewById<TextView>(R.id.text_text)

        val noteTitle = intent.getStringExtra("NOTE_TITLE")
        val noteContent = intent.getStringExtra("NOTE_CONTENT")

        titleTextView.text = noteTitle
        textTextView.text = noteContent
    }
}