package io.github.tuguzd.gamegenbulb.data.model.system.user

import io.github.tuguzd.gamegenbulb.data.model.util.UUIDConverter
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique
import java.util.UUID

@Entity
data class UserEntity(
    @Id var id: Long = 0,
    @Convert(
        converter = UUIDConverter::class,
        dbType = String::class
    )
    @Unique var uuid: UUID? = null,
    @Unique val name: String? = null,
    val displayName: String? = null,
    val role: String? = null,
    @Unique val email: String? = null,
    val avatar: String? = null,
)
