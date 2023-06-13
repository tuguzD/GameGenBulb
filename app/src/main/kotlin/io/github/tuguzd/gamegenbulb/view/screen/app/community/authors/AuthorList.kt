package io.github.tuguzd.gamegenbulb.view.screen.app.community.authors

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import io.github.tuguzd.gamegenbulb.view.util.card.user.UserCardContent

@CommunityNavGraph
@Destination
@Composable
fun AuthorListScreen(
    modifier: Modifier = Modifier,
) {
    val padding = 16.dp

    val list = mutableListOf(
        UserCardContent(
            user = UserData(
                name = "sarali251",
                displayName = "Sarah Ali",
                role = Role.User,
                email = "5ara4.al1@gmail.com",
                phone = null,
                avatar = "https://i.pinimg.com/280x280_RS/3c/96/5c/" +
                        "3c965c1fcea391c74c5ed221487d4de0.jpg",
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
            favourite = false,
        ),
        UserCardContent(
            user = UserData(
                name = "krab_soup",
                displayName = "Tatiana Krabulon",
                role = Role.User,
                email = "tatiana_karbulon@gmail.com",
                phone = null,
                avatar = "https://encrypted-tbn0.gstatic.com/images?q=" +
                        "tbn:ANd9GcSz65YZmQFVx65dog3Z9KgEoYn_ACt__qbGNw&usqp=CAU",
            ),
            categories = null,
            favourite = false,
        ),
        UserCardContent(
            user = UserData(
                name = "isembold",
                displayName = "Isembold Brandagamba",
                role = Role.User,
                email = "i5em.brand@gmail.com",
                phone = null,
                avatar = "https://i0.wp.com/theimaginativeconservative.org/wp-content/" +
                        "uploads/2013/01/Hobbit_drawing_from_lucie_schrimpf.jpeg?ssl=1",
            ),
            categories = listOf(
                Category(
                    name = "Платформер",
                    icon = Icons.Rounded.AutoStories,
                ),
                Category(
                    name = "Пиксель",
                    icon = Icons.Rounded.ColorLens,
                ),
            ),
            favourite = false,
        ),
        UserCardContent(
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
            favourite = false,
        ),
        UserCardContent(
            user = UserData(
                name = "big_manzo_765",
                displayName = "Steven Manzo",
                role = Role.User,
                email = null,
                phone = null,
                avatar = "https://cdn3.iconfinder.com/data/icons/" +
                        "avatar-95/500/Avatar-08-512.png",
            ),
            categories = listOf(
                Category(
                    name = "Симулятор",
                    icon = Icons.Rounded.AutoStories,
                ),
                Category(
                    name = "Пиксель",
                    icon = Icons.Rounded.ColorLens,
                ),
            ),
            favourite = false,
        ),
        UserCardContent(
            user = UserData(
                name = "joy_fast",
                displayName = "Joyce Fuston",
                role = Role.User,
                email = null,
                phone = null,
                avatar = "https://image.api.playstation.com/cdn/UP0082/CUSA01442_00/" +
                        "2RJUxQ52Gcz8SpBwIkHwrD0mIybYHXL3.png?w=440&thumb=false",
            ),
            categories = listOf(
                Category(
                    name = "Приключение",
                    icon = Icons.Rounded.AutoStories,
                ),
                Category(
                    name = "A-класс",
                    icon = Icons.Rounded.Person,
                ),
                Category(
                    name = "3D",
                    icon = Icons.Rounded.ColorLens,
                ),
            ),
            favourite = false,
        ),
    )

    LazyColumn(
        modifier = modifier.padding(horizontal = padding),
    ) {
        item { Spacer(modifier = Modifier.height(padding)) }
        items(list) {
            UserCard(
                user = it.user,
                categories = it.categories,
                isFavourite = it.favourite,
            )
            Spacer(modifier = Modifier.height(padding))
        }
    }
}
