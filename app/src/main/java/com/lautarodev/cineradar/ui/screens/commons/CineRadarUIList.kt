package com.lautarodev.cineradar.ui.screens.commons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lautarodev.cineradar.shows.shows
import androidx.compose.runtime.*


@Composable
fun CineRadarUIList(
    list: List<shows>,
    title: String,
    @androidx.annotation.DrawableRes iconRes: Int? = null,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    var textWidth by remember { mutableStateOf(0) }
    val density = LocalDensity.current

    Column(modifier = modifier) {
        // Título + icono en un Row
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            if (iconRes != null) {
                Image(
                    painter = painterResource(id = iconRes),
                    contentDescription = "Icono sección",
                    modifier = Modifier
                        .size(32.dp)
                        .padding(end = 8.dp)
                )
            }

            // Envolver texto en Column para medir ancho
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        color = Color.White
                    ),
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        textWidth = coordinates.size.width
                    }
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Barra con el ancho igual al ancho del texto
                if (textWidth > 0) {
                    Row(
                        modifier = Modifier
                            .width(with(density) { textWidth.toDp() })
                            .height(4.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .background(Color(0xFFFF0404))
                        )
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .background(Color(0xFF0496FF))
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(list) { show ->
                CineRadarUiItem(show, onClick = onClick)
            }
        }
    }
}
