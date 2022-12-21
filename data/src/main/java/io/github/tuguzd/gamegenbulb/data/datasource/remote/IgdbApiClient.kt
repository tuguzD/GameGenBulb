package io.github.tuguzd.gamegenbulb.data.datasource.remote

import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create

class IgdbApiClient {
    private companion object {
        @OptIn(ExperimentalSerializationApi::class)
        val converterFactory = Json.asConverterFactory("application/json".toMediaType())

        //    private val idClient = "SECRET"
        //    private val secretClient = "SECRET"
        //    private val token: TwitchToken =
        //        TwitchAuthenticator.requestTwitchToken(idClient, secretClient)!!
        const val token = "SECRET"

        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .build()
                chain.proceed(request)
            }.build()
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.igdb.com/v4/")
        .client(okHttpClient).addConverterFactory(converterFactory)
        .addCallAdapterFactory(NetworkResponseAdapterFactory())
        .build()

    internal val gameApi: GameIgdbApi = retrofit.create()
}
