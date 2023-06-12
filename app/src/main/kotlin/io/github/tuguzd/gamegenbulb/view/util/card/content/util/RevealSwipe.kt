package io.github.tuguzd.gamegenbulb.view.util.card.content.util

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Easing
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import de.charlex.compose.RevealDirection
import de.charlex.compose.RevealState
import de.charlex.compose.RevealSwipe
import de.charlex.compose.rememberRevealState
import kotlinx.coroutines.CoroutineScope

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun RevealSwipe(
    modifier: Modifier = Modifier,
    enableSwipe: Boolean = true,
    onContentClick: (() -> Unit)? = null,
    onBackgroundStartClick: () -> Boolean = { true },
    onBackgroundEndClick: () -> Boolean = { true },
    closeOnContentClick: Boolean = true,
    closeOnBackgroundClick: Boolean = false,
    animateBackgroundCardColor: Boolean = true,
    shape: CornerBasedShape = MaterialTheme.shapes.medium,
    alphaEasing: Easing = CubicBezierEasing(0.4f, 0.4f, 0.17f, 0.9f),
    maxRevealDp: Dp = 64.dp,
    maxAmountOfOverflow: Dp = 250.dp,
    directions: Set<RevealDirection> = setOf(
        RevealDirection.StartToEnd,
        RevealDirection.EndToStart
    ),
    contentColor: Color = LocalContentColor.current,
    backgroundCardModifier: Modifier = modifier,
    backgroundCardElevation: Dp = 0.dp,
    backgroundCardStartColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    backgroundCardEndColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    backgroundCardContentColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    state: RevealState = rememberRevealState(),
    hiddenContentEnd: @Composable RowScope.() -> Unit = {},
    hiddenContentStart: @Composable RowScope.() -> Unit = {},
    content: @Composable (Shape) -> Unit
) = RevealSwipe(
    modifier = Modifier,
    enableSwipe = enableSwipe,
    onContentClick = onContentClick,
    backgroundStartActionLabel = null,
    onBackgroundStartClick = {
        onBackgroundStartClick()
        true
    },
    backgroundEndActionLabel = null,
    onBackgroundEndClick = {
        onBackgroundEndClick()
        true
    },
    closeOnContentClick = closeOnContentClick,
    closeOnBackgroundClick = closeOnBackgroundClick,
    animateBackgroundCardColor = animateBackgroundCardColor,
    shape = shape,
    alphaEasing = alphaEasing,
    maxRevealDp = maxRevealDp,
    maxAmountOfOverflow = maxAmountOfOverflow,
    directions = directions,
    contentColor = contentColor,
    backgroundCardModifier = backgroundCardModifier,
    backgroundCardElevation = backgroundCardElevation,
    backgroundCardStartColor = backgroundCardStartColor,
    backgroundCardEndColor = backgroundCardEndColor,
    backgroundCardContentColor = backgroundCardContentColor,
    coroutineScope = coroutineScope,
    state = state,
    hiddenContentEnd = hiddenContentEnd,
    hiddenContentStart = hiddenContentStart,
    content = content,
)
