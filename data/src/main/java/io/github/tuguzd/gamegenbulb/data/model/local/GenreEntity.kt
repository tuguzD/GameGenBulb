package io.github.tuguzd.gamegenbulb.data.model.local

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique
import io.objectbox.relation.ToOne

@Entity
internal data class GenreEntity(
    @Id var id: Long = 0,
    @Unique var name: String? = null,
) {
    lateinit var game: ToOne<GameEntity>
}
