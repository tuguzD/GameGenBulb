package io.github.tuguzd.gamegenbulb.view.util.card.session.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ManageAccounts
import androidx.compose.material.icons.rounded.PersonOutline
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineIconTitle
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineTitle

@Composable
fun ParticipantInfo(
    admin: String,
    participants: List<String>,
) = Row(
    modifier = Modifier
        .height(IntrinsicSize.Min)
        .fillMaxSize()
        .padding(
            start = 16.dp, end = 16.dp,
            top = 8.dp, bottom = 16.dp,
        ),
    horizontalArrangement = Arrangement.spacedBy(16.dp),
) {
    ParticipantNameColumn(
        admin = admin,
        participants = participants,
        modifier = Modifier.weight(1f),
    )
    Divider(
        modifier = Modifier
            .fillMaxHeight()
            .width(1.dp)
    )
    ParticipantRoleColumn(participants)
}

@Composable
private fun ParticipantRoleColumn(
    participants: List<String>,
    modifier: Modifier = Modifier,
) = Column(
    modifier = modifier,
    verticalArrangement = Arrangement.spacedBy(12.dp),
) {
    OneLineIconTitle(
        imageVector = Icons.Rounded.ManageAccounts,
        label = "Администратор",
    )
    participants.forEach {
        OneLineIconTitle(
            imageVector = Icons.Rounded.PersonOutline,
            label = "Участник",
        )
    }
}

@Composable
private fun ParticipantNameColumn(
    admin: String,
    participants: List<String>,
    modifier: Modifier = Modifier,
) = Column(
    modifier = modifier,
    verticalArrangement = Arrangement.spacedBy(12.dp),
) {
    OneLineTitle(
        text = admin,
        style = MaterialTheme.typography.bodyMedium,
    )
    participants.forEach {
        OneLineTitle(
            text = it,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}
