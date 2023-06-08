package io.github.tuguzd.gamegenbulb.view.util.field

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineTitle

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    input: String,
    onInputChange: (String) -> Unit,
    inputVisible: Boolean,
    onInputVisibleChange: (Boolean) -> Unit,
    enabled: Boolean,
    label: String = stringResource(R.string.password),
    trailingIconVisible: Boolean = true,
) {
    val visualTransformation =
        if (inputVisible) VisualTransformation.None
        else PasswordVisualTransformation()

    OutlinedTextField(
        value = input,
        onValueChange = onInputChange,
        modifier = modifier,
        enabled = enabled,
        label = { OneLineTitle(text = label) },
        singleLine = true,
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = block@{
            if (!trailingIconVisible) return@block

            val imageVector =
                if (inputVisible) Icons.Rounded.Visibility
                else Icons.Rounded.VisibilityOff

            val contentDescription =
                if (inputVisible) stringResource(R.string.hide)
                else stringResource(R.string.show)

            IconButton(onClick = { onInputVisibleChange(!inputVisible) }) {
                Icon(imageVector, contentDescription)
            }
        },
    )
}
