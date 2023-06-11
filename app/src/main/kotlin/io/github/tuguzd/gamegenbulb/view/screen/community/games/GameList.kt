package io.github.tuguzd.gamegenbulb.view.screen.community.games

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
import io.github.tuguzd.gamegenbulb.view.screen.community.util.CommunityNavGraph
import io.github.tuguzd.gamegenbulb.view.util.card.Characteristic
import io.github.tuguzd.gamegenbulb.view.util.card.Link

@CommunityNavGraph
@Destination
@Composable
fun GameListScreen(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 16.dp),
    ) {
        item { Spacer(modifier = Modifier.height(16.dp)) }
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
                characteristics = listOf(
                    Characteristic(
                        name = "Стратегия",
                        icon = Icons.Rounded.AutoStories,
                    ),
                    Characteristic(
                        name = "Инди",
                        icon = Icons.Rounded.Person,
                    ),
                    Characteristic(
                        name = "Пиксель",
                        icon = Icons.Rounded.ColorLens,
                    ),
                    Characteristic(
                        name = "ASCII",
                        icon = Icons.Rounded.ColorLens,
                    ),
                ),
            )
            Spacer(modifier = Modifier.height(16.dp))
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
                characteristics = listOf(
                    Characteristic(
                        name = "Стратегия",
                        icon = Icons.Rounded.AutoStories,
                    ),
                    Characteristic(
                        name = "Инди",
                        icon = Icons.Rounded.Person,
                    ),
                    Characteristic(
                        name = "2D",
                        icon = Icons.Rounded.ColorLens,
                    ),
                ),
            )
            Spacer(modifier = Modifier.height(16.dp))
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
                characteristics = listOf(
                    Characteristic(
                        name = "Ролевая",
                        icon = Icons.Rounded.AutoStories,
                    ),
                    Characteristic(
                        name = "А-класс",
                        icon = Icons.Rounded.Person,
                    ),
                    Characteristic(
                        name = "3D",
                        icon = Icons.Rounded.ColorLens,
                    ),
                ),
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
