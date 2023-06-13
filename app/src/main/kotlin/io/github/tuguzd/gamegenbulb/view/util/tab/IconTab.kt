package io.github.tuguzd.gamegenbulb.view.util.tab

import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import io.github.tuguzd.gamegenbulb.view.util.UtilDestination

@Composable
fun <D : UtilDestination> IconTab(
    isPrimary: Boolean,
    destination: D,
    selected: Boolean,
    onClick: () -> Unit,
) = if (isPrimary) PrimaryIconTab(
    destination = destination,
    selected = selected,
    onClick = onClick,
) else SecondaryIconTab(
    destination = destination,
    selected = selected,
    onClick = onClick,
)

@Composable
private fun <D : UtilDestination> PrimaryIconTab(
    destination: D,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    label: String = stringResource(destination.label),
) = Tab(
    modifier = modifier,
    selected = selected, onClick = onClick,
    text = { Text(text = label) },
    icon = { Icon(destination.icon, label) },
)

@Composable
private fun <D : UtilDestination> SecondaryIconTab(
    destination: D,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    label: String = stringResource(destination.label),
) = LeadingIconTab(
    modifier = modifier,
    selected = selected, onClick = onClick,
    text = { Text(text = label) },
    icon = { Icon(destination.icon, label) },
)
