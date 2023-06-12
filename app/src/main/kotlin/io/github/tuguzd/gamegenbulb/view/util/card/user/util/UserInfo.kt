package io.github.tuguzd.gamegenbulb.view.util.card.user.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Tag
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineIconTitle
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineTitle

@Composable
fun UserInfo(
    name: String,
    displayName: String,
    email: String? = null,
    phone: String? = null,
) = Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp),
) {
    OneLineTitle(
        style = MaterialTheme.typography.titleLarge,
        text = displayName,
    )
    OneLineIconTitle(
        imageVector = Icons.Rounded.Tag,
        label = name,
    )
    email?.let {
        OneLineIconTitle(
            imageVector = Icons.Rounded.Email,
            label = it,
        )
    } ?: phone?.let {
        OneLineIconTitle(
            imageVector = Icons.Rounded.Phone,
            label = it,
        )
    }
}
