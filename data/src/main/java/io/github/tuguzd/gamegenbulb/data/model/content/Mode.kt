package io.github.tuguzd.gamegenbulb.data.model.content

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Mode(
    @Id var id: Long = 0,
    var name: String? = null,
)
