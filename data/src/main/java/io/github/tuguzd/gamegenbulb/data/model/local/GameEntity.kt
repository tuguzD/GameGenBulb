package io.github.tuguzd.gamegenbulb.data.model.local

import io.objectbox.annotation.Backlink
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique
import io.objectbox.relation.ToMany

@Entity
internal data class GameEntity(
    @Id(assignable = true) var id: Long = 0,
    @Unique var name: String? = null,
    var desc: String? = null,
) {
    @Backlink(to = "game")
    lateinit var modes: ToMany<ModeEntity>

    @Backlink(to = "game")
    lateinit var genres: ToMany<GenreEntity>
}
