package com.example.assignment10.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.assignment10.database.GamesDatabase
import com.example.assignment10.database.asDomainModel
import com.example.assignment10.domain.Game
import com.example.assignment10.network.Network
import com.example.assignment10.network.asDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GamesRepository(private val database: GamesDatabase) {

    val games: LiveData<List<Game>> = database.gameDao.getGames().map {
        it.asDomainModel()
    }

    suspend fun refreshGames() {
        withContext(Dispatchers.IO) {

            try {
                val playlist = Network.games.getPlaylist().await()
                database.gameDao.insertAll(*playlist.asDomainModel())
            } catch (e: Exception) {
                println("Server Error: $e")
            }

        }
    }
}