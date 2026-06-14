package com.example.android_portfolio.components.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

/**
 * A generic display card with a small label, an optional subtitle, and a large primary value.
 *
 * @param label          Small header text (e.g. "Scheduled Alarm").
 * @param subtitle       Optional secondary text beneath the label.
 * @param value          Large primary text displayed prominently.
 * @param valueColor     Color applied to [value].
 * @param valueFontSize  Font size of [value].
 * @param content        Optional trailing composable slot for additional content.
 */
@Composable
fun InfoDisplayCard(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    valueColor: Color = MaterialTheme.colorScheme.primary,
    valueFontSize: TextUnit = TextUnit.Unspecified,
    content: @Composable ColumnScope.() -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            if (subtitle != null) {
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = value,
                fontSize = valueFontSize,
                fontWeight = FontWeight.ExtraBold,
                color = valueColor
            )

            content()
        }
    }
}
