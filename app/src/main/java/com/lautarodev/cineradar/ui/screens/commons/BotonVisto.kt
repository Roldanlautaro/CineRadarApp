package com.lautarodev.cineradar.ui.screens.commons

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lautarodev.cineradar.R

@Composable
fun BotonVisto(
    onToggle: () -> Unit,
    isVisto: Boolean,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = CircleShape,
        modifier = modifier
            .padding(6.dp)
            .size(32.dp),
        color = Color.Transparent
    ) {
        IconButton(onClick = onToggle) {
            Icon(
                painter = painterResource(
                    id = if (isVisto) R.drawable.vistocheck_icon else R.drawable.visto_icon
                ),
                contentDescription = "Visto",
                modifier = Modifier.size(24.dp),
                tint = if (isVisto) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
