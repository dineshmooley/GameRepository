package com.example.assignment10.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.assignment10.domain.Game

@Entity(tableName = "databasegame")
data class DatabaseGame(

    @PrimaryKey
    val id: Int,
    val title: String,
    val thumbnail: String,
    val shortDescription: String,
    val genre: String
)

fun List<DatabaseGame>.asDomainModel(): List<Game> {
    return map {
        Game(
            id = it.id,
            title = it.title,
            thumbnail = it.thumbnail,
            shortDescription = it.shortDescription,
            genre = it.genre
        )
    }
}