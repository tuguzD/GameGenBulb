package io.github.tuguzd.gamegenbulb.data.model.util

import io.objectbox.converter.PropertyConverter
import java.time.OffsetDateTime

class OffsetDateTimeConverter : PropertyConverter<OffsetDateTime, String> {
    override fun convertToEntityProperty(
        databaseValue: String?,
    ): OffsetDateTime = OffsetDateTime.parse(databaseValue)

    override fun convertToDatabaseValue(
        entityProperty: OffsetDateTime?,
    ): String = entityProperty.toString()
}
