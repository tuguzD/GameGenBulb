package io.github.tuguzd.gamegenbulb.data.datasource.remote

import io.github.tuguzd.gamegenbulb.data.datasource.remote.util.ApiResponse
import io.github.tuguzd.gamegenbulb.data.model.remote.IgdbGame
import retrofit2.http.*

internal interface GameIgdbApi {
    @GET("games")
    suspend fun read(
        @Path("id") id: String,
        @Body query: String =
            "fields name, summary, game_modes.name, genres.name; where id=$id",
    ): ApiResponse<IgdbGame>

    @GET("games")
    suspend fun readAll(
        @Body query: String =
            "fields name, summary, game_modes.name, genres.name;",
    ): ApiResponse<List<IgdbGame>>

    @GET("games")
    suspend fun search(
        input: String,
        @Body query: String =
            "fields name, summary, game_modes.name, genres.name; search \"$input\";",
    ): ApiResponse<List<IgdbGame>>
}
