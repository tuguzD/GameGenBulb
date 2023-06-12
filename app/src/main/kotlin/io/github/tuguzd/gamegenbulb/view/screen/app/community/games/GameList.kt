package io.github.tuguzd.gamegenbulb.view.screen.app.community.games

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
import io.github.tuguzd.gamegenbulb.view.screen.app.community.util.CommunityNavGraph
import io.github.tuguzd.gamegenbulb.view.util.card.Game
import io.github.tuguzd.gamegenbulb.view.util.card.GameCard
import io.github.tuguzd.gamegenbulb.view.util.card.content.Category
import io.github.tuguzd.gamegenbulb.view.util.card.content.Link

@CommunityNavGraph
@Destination
@Composable
fun GameListScreen(
    modifier: Modifier = Modifier,
) {
    val padding = 16.dp
    LazyColumn(
        modifier = modifier.padding(horizontal = padding),
    ) {
        item { Spacer(modifier = Modifier.height(padding)) }
        item {
            GameCard(
                game = Game(
                    name = "Dwarf Fortress",
                    imagePath = "https://cdn.mos.cms.futurecdn.net/9GTJo42N2uEr99T8Svxava.png"
                ),
                links = listOf(
                    Link(
                        name = "Steam",
                        imagePath = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/" +
                                "Steam_icon_logo.svg/768px-Steam_icon_logo.svg.png",
                    ),
                    Link(
                        name = "Itch.io",
                        imagePath = "https://static-00.iconduck.com/assets.00/" +
                                "itch-io-icon-512x512-wwio9bi8.png",
                    ),
                    Link(
                        name = "Bay12 Games",
                        imagePath = "https://media.moddb.com/images/groups/1/6/5721/logo.jpg",
                    ),
                ),
                votePercentage = 95,
                developerName = "Bay12 Games",
                publisherName = "Kitfox Games",
                categories = listOf(
                    Category(
                        name = "Стратегия",
                        icon = Icons.Rounded.AutoStories,
                    ),
                    Category(
                        name = "Инди",
                        icon = Icons.Rounded.Person,
                    ),
                    Category(
                        name = "Пиксель",
                        icon = Icons.Rounded.ColorLens,
                    ),
                    Category(
                        name = "ASCII",
                        icon = Icons.Rounded.ColorLens,
                    ),
                ),
            )
            Spacer(modifier = Modifier.height(padding))
        }
        item {
            GameCard(
                game = Game(
                    name = "RimWorld",
                    imagePath = "https://cdn1.epicgames.com/7051eadbb8c2435caf32a9bc0dc17936/" +
                            "offer/EGS_RimWorld_LudeonStudios_S1-2560x1440-" +
                            "410a62ec21d44260409182e1174cce2e.jpg"
                ),
                links = listOf(
                    Link(
                        name = "Steam",
                        imagePath = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/" +
                                "Steam_icon_logo.svg/768px-Steam_icon_logo.svg.png",
                    ),
                    Link(
                        name = "Epic Games",
                        imagePath = "https://static-00.iconduck.com/assets.00/" +
                                "epic-games-icon-512x512-7qpmojcd.png",
                    ),
                    Link(
                        name = "GOG.com",
                        imagePath = "https://icon-library.com/images/gog-icon/gog-icon-17.jpg",
                    ),
                ),
                votePercentage = 98,
                developerName = "Ludeon Studios",
                categories = listOf(
                    Category(
                        name = "Стратегия",
                        icon = Icons.Rounded.AutoStories,
                    ),
                    Category(
                        name = "Инди",
                        icon = Icons.Rounded.Person,
                    ),
                    Category(
                        name = "2D",
                        icon = Icons.Rounded.ColorLens,
                    ),
                ),
            )
            Spacer(modifier = Modifier.height(padding))
        }
        item {
            GameCard(
                game = Game(
                    name = "The Dwarves",
                    imagePath = "https://images.gog-statics.com/" +
                            "d4395cfca9c5173c14dab2f69bba019abb12dec67f5fc2587cf00ffb8d094e9b_" +
                            "product_card_v2_mobile_slider_639.jpg"
                ),
                links = listOf(
                    Link(
                        name = "Steam",
                        imagePath = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/" +
                                "Steam_icon_logo.svg/768px-Steam_icon_logo.svg.png",
                    ),
                    Link(
                        name = "Epic Games",
                        imagePath = "https://static-00.iconduck.com/assets.00/" +
                                "epic-games-icon-512x512-7qpmojcd.png",
                    ),
                    Link(
                        name = "Xbox",
                        imagePath = "https://cdn.icon-icons.com/icons2/17/" +
                                "PNG/256/microsoft_xbox_xbox360_2158.png",
                    ),
                    Link(
                        name = "PlayStation",
                        imagePath = "https://w7.pngwing.com/pngs/645/422/" +
                                "png-transparent-circle-gaming-playstation-round-" +
                                "icon-popular-services-brands-vol-2-icon.png",
                    ),
                ),
                votePercentage = 74,
                developerName = "KING Art",
                publisherName = "THQ Nordic",
                categories = listOf(
                    Category(
                        name = "Ролевая",
                        icon = Icons.Rounded.AutoStories,
                    ),
                    Category(
                        name = "А-класс",
                        icon = Icons.Rounded.Person,
                    ),
                    Category(
                        name = "3D",
                        icon = Icons.Rounded.ColorLens,
                    ),
                ),
            )
            Spacer(modifier = Modifier.height(padding))
        }
        item {
            GameCard(
                game = Game(
                    name = "Terraria",
                    imagePath = "https://cdn.akamai.steamstatic.com/steam/apps/105600/header.jpg"
                ),
                links = listOf(
                    Link(
                        name = "Steam",
                        imagePath = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/" +
                                "Steam_icon_logo.svg/768px-Steam_icon_logo.svg.png",
                    ),
                    Link(
                        name = "GOG.com",
                        imagePath = "https://icon-library.com/images/gog-icon/gog-icon-17.jpg",
                    ),
                    Link(
                        name = "App Store",
                        imagePath = "https://www.apple.com/v/app-store/b/images/" +
                                "overview/icon_appstore__ev0z770zyxoy_large_2x.png",
                    ),
                    Link(
                        name = "Google Play",
                        imagePath = "https://static.vecteezy.com/system/resources/previews/022/" +
                                "613/026/original/google-play-store-icon-logo-symbol-free-png.png",
                    ),
                    Link(
                        name = "Nintendo Switch",
                        imagePath = "https://cdn.icon-icons.com/icons2/2429/PNG/" +
                                "512/nintendo_logo_icon_147258.png",
                    ),
                    Link(
                        name = "Xbox",
                        imagePath = "https://cdn.icon-icons.com/icons2/17/" +
                                "PNG/256/microsoft_xbox_xbox360_2158.png",
                    ),
                    Link(
                        name = "PlayStation",
                        imagePath = "https://w7.pngwing.com/pngs/645/422/" +
                                "png-transparent-circle-gaming-playstation-round-" +
                                "icon-popular-services-brands-vol-2-icon.png",
                    ),
                ),
                votePercentage = 97,
                developerName = "Re-Logic",
                categories = listOf(
                    Category(
                        name = "Приключение",
                        icon = Icons.Rounded.AutoStories,
                    ),
                    Category(
                        name = "Песочница",
                        icon = Icons.Rounded.AutoStories,
                    ),
                    Category(
                        name = "Инди",
                        icon = Icons.Rounded.Person,
                    ),
                    Category(
                        name = "2D",
                        icon = Icons.Rounded.ColorLens,
                    ),
                ),
            )
            Spacer(modifier = Modifier.height(padding))
        }
    }
}
