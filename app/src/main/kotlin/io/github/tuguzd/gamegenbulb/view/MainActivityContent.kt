package io.github.tuguzd.gamegenbulb.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.tuguzd.gamegenbulb.view.screen.app.AppScreen
import io.github.tuguzd.gamegenbulb.view.theme.AppTheme

@Composable
fun MainActivityContent(
    modifier: Modifier = Modifier,
) = AppTheme {
    Surface(modifier = Modifier.fillMaxSize()) {
        AppScreen(modifier = modifier)
    }
}
