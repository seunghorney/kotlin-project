package ua.nuop.elkamali.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ua.nuop.elkamali.entity.Note
import ua.nuop.elkamali.repo.NoteRepo
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val noteRepo: NoteRepo) : ViewModel() {
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes = _notes.asStateFlow()

    init {
        viewModelScope.launch {
            noteRepo.getPublicNotes().collect {
                _notes.value = it
            }
        }
    }

    fun deleteNote(id: Long) {
        viewModelScope.launch {
            noteRepo.softDeleteNote(id)

        }
    }

    fun toggleVisibility(id: Long){
        viewModelScope.launch {
            noteRepo.toggleVisibility(id)
        }
    }

    fun synchronizeData(){
        viewModelScope.launch {
            noteRepo.synchronizeData()
        }
    }

}