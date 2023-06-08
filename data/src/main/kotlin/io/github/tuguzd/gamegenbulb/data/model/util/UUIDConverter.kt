package io.github.tuguzd.gamegenbulb.data.model.util

import io.objectbox.converter.PropertyConverter
import java.util.UUID

class UUIDConverter : PropertyConverter<UUID, String> {
    override fun convertToEntityProperty(
        databaseValue: String?,
    ): UUID = UUID.fromString(databaseValue)

    override fun convertToDatabaseValue(
        entityProperty: UUID?,
    ): String = entityProperty.toString()
}
