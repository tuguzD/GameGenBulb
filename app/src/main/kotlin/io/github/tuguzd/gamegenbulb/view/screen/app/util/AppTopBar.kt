package io.github.tuguzd.gamegenbulb.view.screen.app.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs
import io.github.tuguzd.gamegenbulb.view.util.BadgeIconButton
import io.github.tuguzd.gamegenbulb.view.util.MyIconButton
import io.github.tuguzd.gamegenbulb.view.util.OneLineTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    title: String = stringResource(R.string.app_name),
    navController: NavController,
) = CenterAlignedTopAppBar(
    modifier = modifier,
    title = { OneLineTitle(text = title) },
    navigationIcon = {
        MyIconButton(
            imageVector = Icons.Rounded.Search,
            contentDescription = stringResource(R.string.search),
        ) {
            navController.navigate(NavGraphs.root)
        }
    },
    actions = {
        BadgeIconButton(
            imageVector = Icons.Rounded.Notifications,
            contentDescription = stringResource(R.string.notifications),
        ) {
            navController.navigate(NavGraphs.root)
        }
    },
)
