package io.github.tuguzd.gamegenbulb.data.model.local

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
