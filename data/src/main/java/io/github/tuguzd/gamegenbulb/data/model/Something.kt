package io.github.tuguzd.gamegenbulb.data.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Something(
    @Id var id: Long
)
