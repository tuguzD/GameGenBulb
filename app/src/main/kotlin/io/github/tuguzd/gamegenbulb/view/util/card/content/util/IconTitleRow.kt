package io.github.tuguzd.gamegenbulb.view.util.card.content.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material.icons.rounded.People
import androidx.compose.material.icons.rounded.Publish
import androidx.compose.material.icons.rounded.RecordVoiceOver
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineIconTitle

@Composable
fun IconTitleRow(
    devPubNeeded: Boolean,
    developerName: String?,
    publisherName: String?,
    creatorName: String?,
    authors: List<String>?,
    defName: String = stringResource(R.string.no_data),
) {
    val devName = developerName ?: publisherName ?: defName
    val pubName = publisherName ?: developerName ?: defName

    var condition = true

    if (devName != defName && pubName != defName || devPubNeeded) {
        if (devName == pubName) {
            if (authors == null && creatorName != null) {
                condition = false
                ModifiedRow {
                    PubDevTitle(label = devName)
                    OneLineIconTitle(
                        imageVector = Icons.Rounded.RecordVoiceOver,
                        label = creatorName,
                    )
                }
            } else PubDevTitle(label = devName)
        } else {
            ModifiedRow {
                OneLineIconTitle(
                    imageVector = Icons.Rounded.Code,
                    label = devName,
                )
                OneLineIconTitle(
                    imageVector = Icons.Rounded.Publish,
                    label = pubName,
                )
            }
        }
    }
    if (condition) {
        creatorName?.let {
            ModifiedRow {
                OneLineIconTitle(
                    imageVector = Icons.Rounded.RecordVoiceOver,
                    label = it,
                )
                authors?.let { list ->
                    OneLineIconTitle(
                        imageVector = Icons.Rounded.People,
                        label = list.joinToString(),
                    )
                }
            }
        }
    }
}

@Composable
private fun ModifiedRow(
    content: @Composable RowScope.() -> Unit,
) = Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(16.dp),
    content = content,
)
