package io.github.tuguzd.gamegenbulb.data.datasource.local

import io.github.tuguzd.gamegenbulb.data.model.local.ModeEntity
import io.github.tuguzd.gamegenbulb.data.model.local.ModeEntity_
import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.content.Mode
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.util.DomainError
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult
import io.github.tuguzd.gamegenbulb.domain.util.success
import io.objectbox.exception.DbException
import io.objectbox.kotlin.awaitCallInTx
import io.objectbox.kotlin.query
import io.objectbox.query.QueryBuilder

class LocalModeDataSource(private val client: DatabaseClient) {
    suspend fun read(id: Id<Mode>): DomainResult<Mode?> = try {
        val entity = client.boxStore.awaitCallInTx {
            client.modeBox.query {
                equal(ModeEntity_.id, id.id.toLong())
            }.findUnique()
        }
        success(entity?.toDomain())
    } catch (dbException: DbException) {
        val error = DomainError.StorageError(
            message = "Failed to get mode by id '$id'",
            cause = dbException,
        )
        error(error)
    } catch (exception: Exception) {
        val error = DomainError.LogicError(
            message = "Failed to get mode by id '$id'",
            cause = exception,
        )
        error(error)
    }

    suspend fun readAll(page: Int, limit: Int = 10, game: Id<Game>):
        DomainResult<List<Mode>> = try {
        val entity = client.boxStore.awaitCallInTx {
            client.modeBox.query {
                orderDesc(ModeEntity_.id)
            }.find(
                (page * limit).toLong(), limit.toLong()
            )
        }!!
        success(
            entity.filter { mode ->
                mode.game.target?.id == game.id.toLong()
            }.map(ModeEntity::toDomain)
        )
    } catch (dbException: DbException) {
        val error = DomainError.StorageError(
            message = "Failed to get modes at page $page with limit $limit",
            cause = dbException,
        )
        error(error)
    } catch (exception: Exception) {
        val error = DomainError.LogicError(
            message = "Failed to get modes at page $page with limit $limit",
            cause = exception,
        )
        error(error)
    }

    suspend fun save(item: Mode): DomainResult<Mode> = try {
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
        success(entity.toDomain())
//        val entity = client.boxStore.awaitCallInTx {
//            val gameEntity = game?.let {
//                client.gameBox.query {
//                    equal(GameEntity_.id, item.id.id.toLong())
//                }.findUnique() ?: throw IllegalArgumentException(
//                    "Game wasn't found by id `$game`"
//                )
//            }
//            val query = client.modeBox.query {
//                equal(ModeEntity_.id, item.id.id.toLong())
//            }
//            val modeEntity = kotlin.run {
//                val entity = query.findUnique()?.apply { name = item.name }
//                if (entity == null && gameEntity == null) {
//                    throw IllegalArgumentException(
//                        "Cannot create genre $item without parent game"
//                    )
//                }
//                entity ?: item.toEntity()
//            }
//            gameEntity?.let { modeEntity.game.target = it }
//            client.modeBox.put(modeEntity)
//            modeEntity
//        }!!
//        success(entity.toDomain())
    } catch (dbException: DbException) {
        val error = DomainError.StorageError(
            message = "Failed to save mode $item",
            cause = dbException,
        )
        error(error)
    } catch (exception: Exception) {
        val error = DomainError.LogicError(
            message = "Failed to save mode $item",
            cause = exception,
        )
        error(error)
    }

    suspend fun search(input: String): DomainResult<List<Mode>> = try {
        val entity = client.boxStore.awaitCallInTx {
            client.modeBox.query {
                contains(
                    ModeEntity_.name, input,
                    QueryBuilder.StringOrder.CASE_INSENSITIVE
                )
            }.find()
        }!!
        success(entity.map(ModeEntity::toDomain))
    } catch (dbException: DbException) {
        val error = DomainError.StorageError(
            message = "Failed to get modes similar to input \"$input\"",
            cause = dbException,
        )
        error(error)
    } catch (exception: Exception) {
        val error = DomainError.LogicError(
            message = "Failed to get modes similar to input \"$input\"",
            cause = exception,
        )
        error(error)
    }
}

internal fun ModeEntity.toDomain() = Mode(
    id = Id(id.toString()), name = name,
)

internal fun Mode.toEntity() = ModeEntity(
    id = id.toString().toLong(), name = name,
)
