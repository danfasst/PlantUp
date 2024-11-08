package br.edu.up.plantup.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.up.plantup.data.back.Reminder
import br.edu.up.plantup.data.back.IRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReminderViewModel(
    private val repository : IRepository
) : ViewModel(){

    private val _reminders = MutableStateFlow<List<Reminder>>(emptyList())
    val reminders: StateFlow<List<Reminder>> get() = _reminders

    init {
        viewModelScope.launch {
            repository.list().collectLatest { list ->
                _reminders.value = list
            }
        }
    }

    fun remove(reminder: Reminder) {
        viewModelScope.launch {
            repository.remove(reminder)
        }
    }

    suspend fun search(reminderId: Int): Reminder? {
        return withContext(Dispatchers.IO){
            repository.search(reminderId)
        }
    }

    fun add(reminder: Reminder) {
        viewModelScope.launch {
            repository.add(reminder)
        }
    }

}
