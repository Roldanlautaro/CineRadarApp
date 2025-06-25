package com.lautarodev.cineradar.ui.screens.commons

import androidx.compose.runtime.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lautarodev.cineradar.R

@Composable
fun BotonLista(
    onToggle: () -> Unit,
    isSaved: Boolean = false,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = CircleShape,
        modifier = modifier
            .padding(6.dp)
            .size(32.dp),
        color = Color.Transparent
    ) {
        IconButton(
            onClick = onToggle
        ) {
            Icon(
                painter = painterResource(
                    id = if (isSaved) R.drawable.listacheck_icon else R.drawable.lista_icon
                ),
                contentDescription = "Lista",
                modifier = Modifier.size(24.dp),
                tint = if (isSaved) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground,
            )
        }
    }
}

