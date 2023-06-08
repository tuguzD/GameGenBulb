package io.github.tuguzd.gamegenbulb.view.util.field

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineTitle

@Composable
fun OneLineTextField(
    modifier: Modifier = Modifier,
    input: String,
    onInputChange: (String) -> Unit,
    enabled: Boolean,
    label: String = stringResource(R.string.default_name),
) = OutlinedTextField(
    value = input,
    onValueChange = onInputChange,
    modifier = modifier,
    enabled = enabled,
    label = { OneLineTitle(text = label) },
    singleLine = true,
)
