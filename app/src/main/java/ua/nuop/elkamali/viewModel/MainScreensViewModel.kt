package ua.nuop.elkamali.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ua.nuop.elkamali.repo.NoteRepo
import javax.inject.Inject

@HiltViewModel
class MainScreensViewModel @Inject constructor(private val noteRepo: NoteRepo):ViewModel() {
    fun synchronize(){
        viewModelScope.launch {
            noteRepo.synchronizeData()
        }
    }
}