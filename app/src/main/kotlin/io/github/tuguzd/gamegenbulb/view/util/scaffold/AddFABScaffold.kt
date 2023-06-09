package io.github.tuguzd.gamegenbulb.view.util.scaffold

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.R

@Composable
fun AddFABScaffold(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    label: String = stringResource(R.string.add),
    smallFAB: @Composable () -> Unit = { },
    content: @Composable (padding: PaddingValues) -> Unit = { },
) = Scaffold(
    modifier = modifier,
    floatingActionButton = {
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            smallFAB()
            ExtendedFloatingActionButton(
                onClick = onClick,
                text = { Text(text = label) },
                icon = { Icon(Icons.Rounded.Add, label) },
            )
        }
    }
) { padding -> content(padding) }
