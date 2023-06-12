package io.github.tuguzd.gamegenbulb.view.screen.app.community.authors

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoStories
import androidx.compose.material.icons.rounded.ColorLens
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UserData
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.role.Role
import io.github.tuguzd.gamegenbulb.view.screen.app.community.util.CommunityNavGraph
import io.github.tuguzd.gamegenbulb.view.util.card.content.Category
import io.github.tuguzd.gamegenbulb.view.util.card.user.UserCard

@CommunityNavGraph
@Destination
@Composable
fun AuthorListScreen(
    modifier: Modifier = Modifier,
) {
    val padding = 16.dp
    LazyColumn(
        modifier = modifier.padding(horizontal = padding),
    ) {
        item { Spacer(modifier = Modifier.height(padding)) }
        item {
            UserCard(
                user = UserData(
                    name = "tuguzD",
                    displayName = "Damir Tugushev",
                    role = Role.User,
                    email = "0damir.1tugushev@gmail.com",
                    phone = "+7 (977) 794-18-85",
                    avatar = "https://avatars.githubusercontent.com/u/56772528",
                ),
                categories = listOf(
                    Category(
                        name = "Песочница",
                        icon = Icons.Rounded.AutoStories,
                    ),
                    Category(
                        name = "Инди",
                        icon = Icons.Rounded.Person,
                    ),
                    Category(
                        name = "Воксель",
                        icon = Icons.Rounded.ColorLens,
                    ),
                ),
            )
            Spacer(modifier = Modifier.height(padding))
        }
    }
}
