package com.lautarodev.cineradar.ui.screens.commons

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.lautarodev.cineradar.shows.shows
import kotlinx.coroutines.delay

@Composable
fun CineRadarRecommendations(
    list: List<shows>,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    val pagerState = remember { mutableIntStateOf(0) }
    val density = LocalDensity.current
    var textWidth by remember { mutableStateOf(0) }

    // Cambio automático cada 6 segundos
    LaunchedEffect(list.size) {
        while (true) {
            delay(6000L)
            if (list.isNotEmpty()) {
                pagerState.intValue = (pagerState.intValue + 1) % list.size
            }
        }
    }

    Column(modifier = modifier) {
        // Título
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            Column {
                Text(
                    text = "\uD83D\uDCA1 RECOMENDACIONES",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.onGloballyPositioned {
                        textWidth = it.size.width
                    }
                )
                Spacer(modifier = Modifier.height(4.dp))
                if (textWidth > 0) {
                    val widthDp = with(density) { textWidth.toDp() }
                    Row(
                        modifier = Modifier
                            .width(widthDp)
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

        Spacer(modifier = Modifier.height(8.dp))

        // Carrusel
        val listSize = list.size
        if (listSize > 0) {
            val currentShow = list[pagerState.intValue]

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ) {
                Crossfade(targetState = currentShow, label = "CrossfadeImage") { show ->
                    AsyncImage(
                        model = show.imageSet.horizontalBackdrop?.w720,
                        contentDescription = show.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth(0.92f)
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(16.dp))
                            .shadow(10.dp, RoundedCornerShape(16.dp), clip = false)
                            .clickable { onClick(show.id) }
                    )
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 24.dp, bottom = 12.dp)
                ) {
                    Text(
                        text = currentShow.title,
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Dots
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(listSize) { index ->
                    val color = if (pagerState.intValue == index) Color(0xFFFF4081) else Color.Gray
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .size(10.dp)
                            .clip(RoundedCornerShape(50))
                            .background(color)
                            .clickable { pagerState.intValue = index }
                    )
                }
            }
        }
    }
}
