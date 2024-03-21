package com.example.sem5_14032024

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val notes: MutableList<Note>, private val onNoteClickListener: OnNoteClickListener) : RecyclerView.Adapter<NoteAdapter.NoteItemHolder>() {

    inner class NoteItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.text_title)
        val previewTextView: TextView = view.findViewById(R.id.text_preview)

        init {
            view.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedNote = notes[position]
                    onNoteClickListener.onNoteClick(clickedNote)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteItemHolder(view)
    }

    override fun onBindViewHolder(holder: NoteItemHolder, position: Int) {
        val note = notes[position]
        holder.titleTextView.text = note.title
        holder.previewTextView.text = note.text.substring(0, minOf(note.text.length, 50))
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    interface OnNoteClickListener {
        fun onNoteClick(note: Note)
    }
}
