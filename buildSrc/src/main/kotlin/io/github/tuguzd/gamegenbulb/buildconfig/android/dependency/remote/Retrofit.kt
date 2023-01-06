package io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.remote

object Retrofit {
    private const val version = "2.9.0"

    const val dependency = "com.squareup.retrofit2:retrofit:$version"
    const val scalarConverter = "com.squareup.retrofit2:converter-scalars:2.9.0"

    object ThirdParty {
        const val kotlinXSerializationConverter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
        const val networkResponseAdapter = "com.github.haroldadmin:NetworkResponseAdapter:5.0.0"
    }

    object Logging {
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:4.10.0"
    }
}
