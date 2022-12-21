package io.github.tuguzd.gamegenbulb.data.model.content

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Game(
    @Id var id: Long = 0,
    var name: String? = null,
    var desc: String? = null,
    var modes: List<Mode> = listOf(),
    var genres: List<Genre> = listOf(),
)
