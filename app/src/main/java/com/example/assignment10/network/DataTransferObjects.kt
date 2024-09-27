package com.example.assignment10.network

import com.example.assignment10.database.DatabaseGame

fun List<GameDetailItem>.asDomainModel(): Array<DatabaseGame> {
    return map {
        DatabaseGame(
            id = it.id,
            title = it.title,
            thumbnail = it.thumbnail,
            shortDescription = it.short_description,
            genre = it.genre
        )
    }.toTypedArray()
}



