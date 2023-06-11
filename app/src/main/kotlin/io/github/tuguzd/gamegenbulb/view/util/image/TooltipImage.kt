package io.github.tuguzd.gamegenbulb.view.util.image

import androidx.compose.foundation.clickable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.google.accompanist.placeholder.material.placeholder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TooltipImage(
    modifier: Modifier = Modifier,
    label: String,
    imagePath: String,
    crossfade: Boolean = true,
    colorFilter: ColorFilter? = null,
    error: @Composable (() -> Unit)? = null,
    onClick: () -> Unit = { },
) = PlainTooltipBox(
    tooltip = { Text(label) }
) {
    val model = ImageRequest.Builder(LocalContext.current)
        .data(imagePath)
        .crossfade(crossfade)
        .build()
    var isLoading by remember { mutableStateOf(true) }

    SubcomposeAsyncImage(
        modifier = modifier
            .tooltipAnchor()
            .placeholder(visible = isLoading)
            .clickable(onClick = onClick),
        model = model,
        contentDescription = label,
        contentScale = ContentScale.Crop,
        colorFilter = colorFilter,
        error = error?.let { { it() } },
        onLoading = { isLoading = true },
        onSuccess = { isLoading = false },
        onError = { isLoading = false },
    )
}
