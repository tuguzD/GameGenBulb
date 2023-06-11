package io.github.tuguzd.gamegenbulb.view.util.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.util.button.OneLineTextButton
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineTitle

@Composable
fun ConfirmDialog(
    title: String,
    supportText: String,
    onConfirmation: (Boolean) -> Unit,
) = Surface(
    shape = MaterialTheme.shapes.large
) {
    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            OneLineTitle(
                text = title,
                style = MaterialTheme.typography.titleLarge,
            )
            Text(text = supportText)
        }
        Row(
            modifier = Modifier.align(Alignment.End),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            OneLineTextButton(
                text = stringResource(R.string.cancel),
                onClick = { onConfirmation(false) },
            )
            OneLineTextButton(
                text = title,
                onClick = { onConfirmation(true) },
            )
        }
    }
}
