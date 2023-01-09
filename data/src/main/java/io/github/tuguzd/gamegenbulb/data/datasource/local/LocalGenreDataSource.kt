package io.github.tuguzd.gamegenbulb.data.datasource.local

import io.github.tuguzd.gamegenbulb.data.model.local.GenreEntity
import io.github.tuguzd.gamegenbulb.data.model.local.GenreEntity_
import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.content.Genre
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult
import io.github.tuguzd.gamegenbulb.domain.util.success
import io.objectbox.kotlin.awaitCallInTx
import io.objectbox.kotlin.query
import io.objectbox.query.QueryBuilder

class LocalGenreDataSource(private val client: DatabaseClient) {
    suspend fun read(id: Id<Genre>): DomainResult<Genre?> {
        val entity = client.boxStore.awaitCallInTx {
            client.genreBox.query {
                equal(
                    GenreEntity_.id, id.id,
                    QueryBuilder.StringOrder.CASE_SENSITIVE
                )
            }.findUnique()
        }
        return success(entity?.toDomain())
    }

    suspend fun readAll(page: Int, game: Id<Game>): DomainResult<List<Genre>> = success(
        client.boxStore.awaitCallInTx { client.genreBox.all }!!
            .filter { genre ->
                genre.game.target?.id == game.id.toLong()
            }.map(GenreEntity::toDomain)
    )

    suspend fun save(item: Genre): DomainResult<Genre> {
        val entity = client.boxStore.awaitCallInTx {
            val query = client.genreBox.query {
                equal(
                    GenreEntity_.id, item.id.id,
                    QueryBuilder.StringOrder.CASE_SENSITIVE
                )
            }
            val entity = query.findUnique()
                ?.apply { name = item.name }
                ?: item.toEntity()
            client.genreBox.put(entity)
            entity
        }!!
        return success(entity.toDomain())
    }

    suspend fun search(input: String): DomainResult<List<Genre>> {
        val entity = client.boxStore.awaitCallInTx {
            client.genreBox.query {
                contains(
                    GenreEntity_.name, input,
                    QueryBuilder.StringOrder.CASE_INSENSITIVE
                )
            }.find()
        }!!
        return success(entity.map(GenreEntity::toDomain))
    }
}

internal fun GenreEntity.toDomain() = Genre(
    id = Id(id.toString()), name = name,
)

internal fun Genre.toEntity() = GenreEntity(
    id = id.toString().toLong(), name = name,
)
