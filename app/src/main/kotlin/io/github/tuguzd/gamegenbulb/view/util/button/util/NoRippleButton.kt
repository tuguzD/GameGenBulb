package io.github.tuguzd.gamegenbulb.view.util.button.util

import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

@Composable
fun NoRippleButton(
    content: @Composable () -> Unit,
) = CompositionLocalProvider(
    LocalRippleTheme provides NoRippleTheme,
    content = content,
)

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha =
        RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
}
