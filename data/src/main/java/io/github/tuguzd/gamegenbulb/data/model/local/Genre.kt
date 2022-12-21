package io.github.tuguzd.gamegenbulb.data.model.local

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Genre(
    @Id var id: Long = 0,
    var name: String? = null,
)
