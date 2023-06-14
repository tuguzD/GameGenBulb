package io.github.tuguzd.gamegenbulb.view.util.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.BookmarkBorder
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.util.button.util.NoRippleButton

@Composable
fun FavouriteIconButton(
    isFavourite: Boolean,
    onClick: () -> Unit,
) = NoRippleButton {
    TooltipIconButton(
        imageVector = run {
            if (isFavourite) Icons.Rounded.Bookmark
            else Icons.Rounded.BookmarkBorder
        },
        contentDescription = stringResource(
            if (!isFavourite) R.string.do_favourite
            else R.string.do_unfavourite
        ),
        iconTint = run {
            if (isFavourite) MaterialTheme.colorScheme.primary
            else LocalContentColor.current
        },
        onClick = onClick,
    )
}
