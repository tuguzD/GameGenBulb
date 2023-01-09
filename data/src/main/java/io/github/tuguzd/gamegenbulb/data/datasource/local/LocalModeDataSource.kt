package io.github.tuguzd.gamegenbulb.data.datasource.local

import io.github.tuguzd.gamegenbulb.data.datasource.interfaces.ModeDataSource
import io.github.tuguzd.gamegenbulb.data.model.local.ModeEntity
import io.github.tuguzd.gamegenbulb.data.model.local.ModeEntity_
import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.content.Mode
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult
import io.github.tuguzd.gamegenbulb.domain.util.success
import io.objectbox.kotlin.awaitCallInTx
import io.objectbox.kotlin.query
import io.objectbox.query.QueryBuilder

class LocalModeDataSource(private val client: DatabaseClient) : ModeDataSource {
    override suspend fun read(id: Id<Mode>): DomainResult<Mode?> {
        val entity = client.boxStore.awaitCallInTx {
            client.modeBox.query {
                equal(
                    ModeEntity_.id, id.id,
                    QueryBuilder.StringOrder.CASE_SENSITIVE
                )
            }.findUnique()
        }
        return success(entity?.toDomain())
    }

    override suspend fun readAll(page: Int, game: Id<Game>): DomainResult<List<Mode>> = success(
        client.boxStore.awaitCallInTx { client.modeBox.all }!!
            .filter { mode ->
                mode.game.target?.id == game.id.toLong()
            }.map(ModeEntity::toDomain)
    )

    override suspend fun save(item: Mode): DomainResult<Mode> {
        val entity = client.boxStore.awaitCallInTx {
            val query = client.modeBox.query {
                equal(
                    ModeEntity_.id, item.id.id,
                    QueryBuilder.StringOrder.CASE_SENSITIVE
                )
            }
            val entity = query.findUnique()
                ?.apply { name = item.name }
                ?: item.toEntity()
            client.modeBox.put(entity)
            entity
        }!!
        return success(entity.toDomain())
    }

    override suspend fun search(input: String): DomainResult<List<Mode>> {
        val entity = client.boxStore.awaitCallInTx {
            client.modeBox.query {
                contains(
                    ModeEntity_.name, input,
                    QueryBuilder.StringOrder.CASE_INSENSITIVE
                )
            }.find()
        }!!
        return success(entity.map(ModeEntity::toDomain))
    }
}

internal fun ModeEntity.toDomain() = Mode(
    id = Id(id.toString()), name = name,
)

internal fun Mode.toEntity() = ModeEntity(
    id = id.toString().toLong(), name = name,
)
