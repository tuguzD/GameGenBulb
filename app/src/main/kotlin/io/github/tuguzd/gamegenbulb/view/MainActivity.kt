package io.github.tuguzd.gamegenbulb.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.github.tuguzd.gamegenbulb.viewmodel.user.current.CurrentUserViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: CurrentUserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent(viewModel = viewModel)
        }
    }
}
