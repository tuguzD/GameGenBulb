package io.github.tuguzd.gamegenbulb.view.screen.community.util

import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun CommunityIconTab(
    modifier: Modifier = Modifier,
    destination: CommunityDestination,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val label = stringResource(destination.label)
    LeadingIconTab(
        modifier = modifier,
        selected = selected, onClick = onClick,
        text = { Text(text = label) },
        icon = { Icon(destination.icon, label) },
    )
}
