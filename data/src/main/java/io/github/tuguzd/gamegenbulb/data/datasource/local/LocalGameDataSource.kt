package io.github.tuguzd.gamegenbulb.data.datasource.local

import io.github.tuguzd.gamegenbulb.data.model.local.GameEntity
import io.github.tuguzd.gamegenbulb.data.model.local.GameEntity_
import io.github.tuguzd.gamegenbulb.data.model.local.GenreEntity
import io.github.tuguzd.gamegenbulb.data.model.local.ModeEntity
import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.util.DomainError
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult
import io.github.tuguzd.gamegenbulb.domain.util.success
import io.objectbox.exception.DbException
import io.objectbox.kotlin.awaitCallInTx
import io.objectbox.kotlin.query
import io.objectbox.query.QueryBuilder

class LocalGameDataSource(private val client: DatabaseClient) {
    suspend fun read(id: Id<Game>): DomainResult<Game?> = try {
        val entity = client.boxStore.awaitCallInTx {
            client.gameBox.query {
                equal(GameEntity_.id, id.id.toLong())
            }.findUnique()
        }
        success(entity?.toDomain())
    } catch (dbException: DbException) {
        val error = DomainError.StorageError(
            message = "Failed to get game by id '$id'",
            cause = dbException,
        )
        error(error)
    } catch (exception: Exception) {
        val error = DomainError.LogicError(
            message = "Failed to get game by id '$id'",
            cause = exception,
        )
        error(error)
    }

    suspend fun readAll(page: Int, limit: Int = 10): DomainResult<List<Game>> = try {
        val entity = client.boxStore.awaitCallInTx {
            client.gameBox.query {
                orderDesc(GameEntity_.id)
            }.find(
                (page * limit).toLong(), limit.toLong()
            )
        }!!
        success(entity.map(GameEntity::toDomain))
    } catch (dbException: DbException) {
        val error = DomainError.StorageError(
            message = "Failed to get games at page $page with limit $limit",
            cause = dbException,
        )
        error(error)
    } catch (exception: Exception) {
        val error = DomainError.LogicError(
            message = "Failed to get games at page $page with limit $limit",
            cause = exception,
        )
        error(error)
    }

    suspend fun save(item: Game): DomainResult<Game> = try {
        val entity = client.boxStore.awaitCallInTx {
            val query = client.gameBox.query {
                equal(GameEntity_.id, item.id.id.toLong())
            }
            val entity = query.findUnique()?.apply {
                name = item.name; desc = item.desc
            } ?: item.toEntity()
            client.gameBox.put(entity)
            entity
        }!!
        success(entity.toDomain())
    } catch (dbException: DbException) {
        val error = DomainError.StorageError(
            message = "Failed to save game $item",
            cause = dbException,
        )
        error(error)
    } catch (exception: Exception) {
        val error = DomainError.LogicError(
            message = "Failed to save game $item",
            cause = exception,
        )
        error(error)
    }

    suspend fun search(input: String): DomainResult<List<Game>> = try {
        val entity = client.boxStore.awaitCallInTx {
            client.gameBox.query {
                contains(
                    GameEntity_.name, input,
                    QueryBuilder.StringOrder.CASE_INSENSITIVE
                )
            }.find()
        }!!
        success(entity.map(GameEntity::toDomain))
    } catch (dbException: DbException) {
        val error = DomainError.StorageError(
            message = "Failed to get games similar to input \"$input\"",
            cause = dbException,
        )
        error(error)
    } catch (exception: Exception) {
        val error = DomainError.LogicError(
            message = "Failed to get games similar to input \"$input\"",
            cause = exception,
        )
        error(error)
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
