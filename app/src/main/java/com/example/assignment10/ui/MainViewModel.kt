package com.example.assignment10.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.assignment10.database.getDatabase
import com.example.assignment10.repository.GamesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val database = getDatabase(application)
    private val gamesRepository = GamesRepository(database)

    init {
        viewModelScope.launch {
            gamesRepository.refreshGames()
        }
    }

    val playlist = gamesRepository.games

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}