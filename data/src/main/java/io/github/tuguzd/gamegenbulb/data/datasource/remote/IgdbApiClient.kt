package io.github.tuguzd.gamegenbulb.data.datasource.remote

import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create

class IgdbApiClient {
    private companion object {
        @OptIn(ExperimentalSerializationApi::class)
        val jsonConverterFactory = Json.asConverterFactory("application/json".toMediaType())
        val scalarConverterFactory: ScalarsConverterFactory = ScalarsConverterFactory.create()

        const val token = "SECRET"
        const val clientId = "SECRET"

        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .addHeader("Client-ID", clientId)
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    setLevel(Level.BODY)
                }
            ).build()
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.igdb.com/v4/").client(okHttpClient)
        .addConverterFactory(scalarConverterFactory)
        .addConverterFactory(jsonConverterFactory)
        .addCallAdapterFactory(NetworkResponseAdapterFactory())
        .build()

    internal val gameApi: GameIgdbApi = retrofit.create()
}
