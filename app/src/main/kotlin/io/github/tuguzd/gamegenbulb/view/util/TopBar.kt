package io.github.tuguzd.gamegenbulb.view.util

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import io.github.tuguzd.gamegenbulb.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String = stringResource(R.string.app_name),
) = CenterAlignedTopAppBar(
    modifier = modifier,
    title = { Text(text = title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
)
