package com.example.android_portfolio.components.shared

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * A full-width button with an icon and label text.
 *
 * @param text       Button label.
 * @param icon       Leading icon vector.
 * @param onClick    Tap callback.
 * @param modifier   Optional modifier applied to the button.
 * @param height     Button height (default 56 dp).
 * @param iconSize   Icon size (default 20 dp).
 * @param filled     When `true` uses [Button]; when `false` uses [OutlinedButton].
 */
@Composable
fun FullWidthIconButton(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    height: Dp = 56.dp,
    iconSize: Dp = 20.dp,
    filled: Boolean = true
) {
    val buttonModifier = modifier
        .fillMaxWidth()
        .height(height)

    val content: @Composable RowScope.() -> Unit = {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(iconSize)
        )
        Spacer(Modifier.width(8.dp))
        Text(text)
    }

    if (filled) {
        Button(
            onClick = onClick,
            modifier = buttonModifier,
            content = content
        )
    } else {
        OutlinedButton(
            onClick = onClick,
            modifier = buttonModifier,
            content = content
        )
    }
}
