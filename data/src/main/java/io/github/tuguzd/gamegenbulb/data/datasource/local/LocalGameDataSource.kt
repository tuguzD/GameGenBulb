package io.github.tuguzd.gamegenbulb.data.datasource.local

import io.github.tuguzd.gamegenbulb.data.datasource.interfaces.GameDataSource
import io.github.tuguzd.gamegenbulb.data.model.local.GameEntity
import io.github.tuguzd.gamegenbulb.data.model.local.GameEntity_
import io.github.tuguzd.gamegenbulb.data.model.local.GenreEntity
import io.github.tuguzd.gamegenbulb.data.model.local.ModeEntity
import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult
import io.github.tuguzd.gamegenbulb.domain.util.success
import io.objectbox.kotlin.awaitCallInTx
import io.objectbox.kotlin.query
import io.objectbox.query.QueryBuilder

class LocalGameDataSource(private val client: DatabaseClient) : GameDataSource {
    override suspend fun read(id: Id<Game>): DomainResult<Game?> {
        val entity = client.boxStore.awaitCallInTx {
            client.gameBox.query {
                equal(
                    GameEntity_.id, id.id,
                    QueryBuilder.StringOrder.CASE_SENSITIVE
                )
            }.findUnique()
        }
        return success(entity?.toDomain())
    }

    override suspend fun readAll(page: Int): DomainResult<List<Game>> = success(
        client.boxStore.awaitCallInTx { client.gameBox.all }!!
            .map(GameEntity::toDomain)
    )

    override suspend fun save(item: Game): DomainResult<Game> {
        val entity = client.boxStore.awaitCallInTx {
            val query = client.gameBox.query {
                equal(
                    GameEntity_.id, item.id.id,
                    QueryBuilder.StringOrder.CASE_SENSITIVE
                )
            }
            val entity = query.findUnique()?.apply {
                name = item.name; desc = item.desc
            } ?: item.toEntity()
            client.gameBox.put(entity)
            entity
        }!!
        return success(entity.toDomain())
    }

    override suspend fun search(input: String): DomainResult<List<Game>> {
        val entity = client.boxStore.awaitCallInTx {
            client.gameBox.query {
                contains(
                    GameEntity_.name, input,
                    QueryBuilder.StringOrder.CASE_INSENSITIVE
                )
            }.find()
        }!!
        return success(entity.map(GameEntity::toDomain))
    }
}

internal fun GameEntity.toDomain() = Game(
    id = Id(id.toString()),
    name = name, desc = desc,
    modes = modes.map(ModeEntity::toDomain),
    genres = genres.map(GenreEntity::toDomain),
)

internal fun Game.toEntity() = GameEntity(
    id = id.toString().toLong(),
    name = name, desc = desc,
)
