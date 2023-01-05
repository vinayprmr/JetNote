package com.example.jetnote.data

import com.example.jetnote.model.Note

class NotesDataSource() {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "title1", desc = "desc 1"),
            Note(title = "title1", desc = "desc 1"),
            Note(title = "title1", desc = "desc 1"),
            Note(title = "title1", desc = "desc 1"),
            Note(title = "title1", desc = "desc 1"),
            Note(title = "title1", desc = "desc 1"),
            Note(title = "title1", desc = "desc 1"),
            Note(title = "title1", desc = "desc 1"),
            Note(title = "title1", desc = "desc 1"),
            Note(title = "title1", desc = "desc 1"),
            Note(title = "title1", desc = "desc 1"),
        )
    }
}

