package io.github.tuguzd.gamegenbulb.view.screen.app.profile.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.Circle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Insights
import androidx.compose.material.icons.rounded.Lightbulb
import androidx.compose.material.icons.rounded.ManageAccounts
import androidx.compose.material.icons.rounded.People
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Psychology
import androidx.compose.material.icons.rounded.SettingsSuggest
import androidx.compose.material.icons.rounded.SportsEsports
import androidx.compose.material.icons.rounded.Tag
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.material.placeholder
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UserData
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.User
import io.github.tuguzd.gamegenbulb.view.util.card.content.util.ContentImage
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineTitle

@Composable
fun UserContent(
    user: User?,
) = Column(
    modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.spacedBy(16.dp)
) {
    UserDataCard(
        user = user?.data,
        modifier = Modifier.fillMaxWidth(),
    )
    Surface(
        modifier = Modifier.fillMaxWidth(),
        tonalElevation = 1.dp,
    ) {
        Column {
            OneLineTitle(
                modifier = Modifier.padding(
                    start = 16.dp, end = 16.dp,
                    top = 16.dp, bottom = 8.dp,
                ),
                text = stringResource(R.string.favourite),
                style = MaterialTheme.typography.titleLarge,
            )
            Action(
                data = stringResource(R.string.authors),
                icon = Icons.Rounded.People,
                modifier = Modifier.fillMaxWidth(),
            )
            Action(
                data = stringResource(R.string.ideas),
                icon = Icons.Rounded.Lightbulb,
                modifier = Modifier.fillMaxWidth(),
            )
            Action(
                data = stringResource(R.string.games),
                icon = Icons.Rounded.SportsEsports,
                modifier = Modifier.fillMaxWidth(),
            )
            Action(
                data = stringResource(R.string.sessions),
                icon = Icons.Rounded.Psychology,
                modifier = Modifier.fillMaxWidth(),
            )
            Action(
                data = stringResource(R.string.analyzes),
                icon = Icons.Rounded.Insights,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
    Surface(
        modifier = Modifier.fillMaxWidth(),
        tonalElevation = 1.dp,
    ) {
        Column {
            OneLineTitle(
                modifier = Modifier.padding(
                    start = 16.dp, end = 16.dp,
                    top = 16.dp, bottom = 8.dp,
                ),
                text = stringResource(R.string.settings),
                style = MaterialTheme.typography.titleLarge,
            )
            Action(
                data = stringResource(R.string.user_settings),
                icon = Icons.Rounded.ManageAccounts,
                modifier = Modifier.fillMaxWidth(),
            )
            Action(
                data = stringResource(R.string.app_settings),
                icon = Icons.Rounded.SettingsSuggest,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Composable
private fun UserActions(
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        tonalElevation = 1.dp,
    ) {
        Column {
            OneLineTitle(
                text = stringResource(R.string.favourite),
                style = MaterialTheme.typography.titleLarge,
            )
            Action(
                data = stringResource(R.string.authors),
                icon = Icons.Rounded.Bookmark,
                modifier = Modifier.fillMaxWidth(),
            )
            Action(
                data = stringResource(R.string.ideas),
                icon = Icons.Rounded.Bookmark,
                modifier = Modifier.fillMaxWidth(),
            )
            Action(
                data = stringResource(R.string.games),
                icon = Icons.Rounded.Bookmark,
                modifier = Modifier.fillMaxWidth(),
            )
            Action(
                data = stringResource(R.string.sessions),
                icon = Icons.Rounded.Bookmark,
                modifier = Modifier.fillMaxWidth(),
            )
            Action(
                data = stringResource(R.string.analyzes),
                icon = Icons.Rounded.Bookmark,
                modifier = Modifier.fillMaxWidth(),
            )
        }
        Column {
            OneLineTitle(
                text = stringResource(R.string.settings),
                style = MaterialTheme.typography.titleLarge,
            )
            Action(
                data = stringResource(R.string.user_settings),
                icon = Icons.Rounded.ManageAccounts,
                modifier = Modifier.fillMaxWidth(),
            )
            Action(
                data = stringResource(R.string.app_settings),
                icon = Icons.Rounded.SettingsSuggest,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Composable
private fun Action(
    modifier: Modifier = Modifier,
    data: String = stringResource(R.string.default_name),
    icon: ImageVector = Icons.Rounded.Circle,
    onClick: () -> Unit = { },
) = Box(
    modifier = modifier.clickable(onClick = onClick),
) {
    UserItemRow(
        data = data,
        icon = icon,
        modifier = modifier.padding(16.dp),
    )
}

@Composable
private fun UserDataCard(
    user: UserData?,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        tonalElevation = 1.dp,
    ) {
        Row {
            ContentImage(
                modifier = Modifier.size(160.dp),
                label = stringResource(R.string.user_avatar),
                contentImage = user?.avatar,
            )
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                OneLineTitle(
                    text = user?.displayName ?: "",
                    style = MaterialTheme.typography.titleLarge,
                )
                UserItemRow(
                    data = user?.name,
                    icon = Icons.Rounded.Tag,
                )
                UserItemRow(
                    data = user?.email,
                    icon = Icons.Rounded.Email,
                )
                UserItemRow(
                    data = user?.phone,
                    icon = Icons.Rounded.Phone,
                )
            }
        }
    }
}

@Composable
private fun UserItemRow(
    data: String?,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    iconDescription: String? = null,
    placeholder: String = "placeholder",
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Icon(imageVector = icon, contentDescription = iconDescription)
        OneLineTitle(
            style = style,
            text = data ?: placeholder,
            modifier = Modifier.placeholder(visible = data == null),
        )
    }
}
