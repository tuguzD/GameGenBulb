package io.github.tuguzd.gamegenbulb.data.model.game.data

import io.github.tuguzd.gamegenbulb.data.model.util.OffsetDateTimeConverter
import io.github.tuguzd.gamegenbulb.data.model.util.UUIDConverter
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique
import io.objectbox.relation.ToMany
import java.time.OffsetDateTime
import java.util.UUID

@Entity
internal data class GameEntity(
    @Id var id: Long = 0,
    @Convert(
        converter = UUIDConverter::class,
        dbType = String::class
    )
    @Unique var uuid: UUID? = null,
    @Unique val name: String? = null,
    val description: String? = null,
    @Convert(
        converter = OffsetDateTimeConverter::class,
        dbType = String::class
    )
    val publishDate: OffsetDateTime? = null,
    @Convert(
        converter = OffsetDateTimeConverter::class,
        dbType = String::class
    )
    val updateDate: OffsetDateTime? = null,
) {
    var socialMedia: MutableList<MediaLinkEntity>? =
        ToMany(this, GameEntity_.socialMedia)
    var dataSource: MutableList<DataSourceLinkEntity>? =
        ToMany(this, GameEntity_.dataSource)
    var category: MutableList<GameCategoryEntity>? =
        ToMany(this, GameEntity_.category)
}

@Entity
internal data class MediaLinkEntity(
    @Id var id: Long = 0,
)

@Entity
internal data class DataSourceLinkEntity(
    @Id var id: Long = 0,
)

@Entity
internal data class GameCategoryEntity(
    @Id var id: Long = 0,
)
