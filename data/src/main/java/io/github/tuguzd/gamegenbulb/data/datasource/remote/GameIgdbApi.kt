package io.github.tuguzd.gamegenbulb.data.datasource.remote

import io.github.tuguzd.gamegenbulb.data.datasource.remote.util.ApiResponse
import io.github.tuguzd.gamegenbulb.data.model.remote.IgdbGame
import retrofit2.http.*

internal interface GameIgdbApi {
    companion object {
        const val query = "fields name, summary, game_modes.name, genres.name;" +
            "where aggregated_rating >= 95 & rating != 0;"
    }

    @POST("games")
    suspend fun readOne(@Body body: String = query): ApiResponse<IgdbGame>

    @POST("games")
    suspend fun readList(@Body body: String = query): ApiResponse<List<IgdbGame>>
}

internal suspend fun GameIgdbApi.readAll(page: Int = 0, limit: Int = 6):
    ApiResponse<List<IgdbGame>> = readList(
    GameIgdbApi.query + "limit $limit; offset ${page * limit};",
)

internal suspend fun GameIgdbApi.read(id: String):
    ApiResponse<IgdbGame> = readOne(
    GameIgdbApi.query + "where id=$id",
)

internal suspend fun GameIgdbApi.search(input: String):
    ApiResponse<List<IgdbGame>> = readList(
    GameIgdbApi.query + "search \"$input\";"
)
