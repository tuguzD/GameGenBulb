package io.github.tuguzd.gamegenbulb.app.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint
import io.github.tuguzd.gamegenbulb.app.view.screen.EntryScreen
import io.github.tuguzd.gamegenbulb.app.view.ui.theme.GameGenBulbTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)
        setContent {
            GameGenBulbTheme {
                EntryScreen()
            }
        }
    }
}
