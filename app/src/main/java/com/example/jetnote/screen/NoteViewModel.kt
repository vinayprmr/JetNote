package com.example.jetnote.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnote.model.Note
import com.example.jetnote.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {
//    var notesList = mutableStateListOf<Note>()
    private val _notesList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _notesList.asStateFlow()
    init {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getAllNotes().distinctUntilChanged().collect{ listOfNotes->
                if (listOfNotes.isNullOrEmpty()){
                    Log.d("TAGViewModel", "EMptylist: ")
                }else{
                    _notesList.value = listOfNotes
                }
            }
        }
    }

    fun addNote(note: Note) = viewModelScope.launch {
        noteRepository.addNote(note)
    }
    fun removeNote(note: Note) = viewModelScope.launch {
        noteRepository.deleteNote(note)
    }
    fun updateNote(note: Note) = viewModelScope.launch {
        noteRepository.updateNote(note)
    }
}