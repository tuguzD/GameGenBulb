@file:Suppress("unused")

package io.github.tuguzd.gamegenbulb.data.datasource.util

import com.apollographql.apollo3.ApolloClient

class RemoteClient(serverUrl: String) {
    internal val client = ApolloClient.Builder()
        .serverUrl(serverUrl)
        .build()
}
