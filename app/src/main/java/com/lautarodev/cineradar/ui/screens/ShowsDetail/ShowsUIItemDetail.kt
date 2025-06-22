package com.lautarodev.cineradar.ui.screens.ShowsDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.lautarodev.cineradar.R
import com.lautarodev.cineradar.shows.shows
import com.lautarodev.cineradar.ui.screens.commons.Navbar

@Composable
fun ShowsUiItemDetail(shows: shows, navController: NavHostController) {
    val density = LocalDensity.current
    var textWidth by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            Navbar(navController = navController)
        },
        containerColor = Color.Black
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.Black)
        ) {
            // Imagen horizontal con botones
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                AsyncImage(
                    model = shows.imageSet.horizontalBackdrop?.w720,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Row(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(12.dp)
                ) {
                    IconWithBackground(
                        iconId = R.drawable.lista_icon,
                        onClick = { /* TODO: agregar a lista */ }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    IconWithBackground(
                        iconId = R.drawable.visto_icon,
                        onClick = { /* TODO: marcar como visto */ }
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(150.dp)
                        .offset(y = (-40).dp) // hace que "pise" la imagen horizontal
                        .clip(RoundedCornerShape(12.dp))
                ) {
                    AsyncImage(
                        model = shows.imageSet.verticalPoster?.w360,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomStart)
                            .background(Color.Black.copy(alpha = 0.6f))
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.imdb_icon),
                            contentDescription = "IMDb",
                            modifier = Modifier.height(16.dp)
                        )
                        Text(
                            text = shows.rating.toString(),
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    TitleWithBar(title = shows.title)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${shows.releaseYear} · Directed by ${shows.directors?.firstOrNull() ?: "N/A"}",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "Duración ${shows.runtime}m",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 📝 Descripción
            SectionTitleWithBar("- Descripción :")
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = shows.overview,
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 🎭 Actores
            SectionTitleWithBar("- Actores :")
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = shows.cast?.joinToString(", ") ?: "No disponible",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Plataforma dinámica
            val plataformaIcon = when (shows.showType.lowercase()) {
                "netflix" -> R.drawable.netflix_icon
                "disney" -> R.drawable.disney_icon
                "max" -> R.drawable.hbo_icon
                else -> R.drawable.generic_icon
            }

            SectionTitleWithBar("📺 ¿En qué plataforma se encuentran? :")
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = plataformaIcon),
                    contentDescription = "Plataforma",
                    modifier = Modifier.height(36.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Ver acá!",
                    color = Color.Cyan,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun IconWithBackground(iconId: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .background(Color.Black.copy(alpha = 0.6f), shape = RoundedCornerShape(50))
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(20.dp)
        )
    }
}

// Título principal con barra roja y azul
@Composable
fun TitleWithBar(title: String) {
    var textWidth by remember { mutableStateOf(0) }
    val density = LocalDensity.current

    Column {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.onGloballyPositioned {
                textWidth = it.size.width
            }
        )
        Spacer(modifier = Modifier.height(4.dp))
        if (textWidth > 0) {
            Row(
                modifier = Modifier
                    .width(with(density) { textWidth.toDp() })
                    .height(4.dp)
            ) {
                Box(modifier = Modifier.weight(1f).fillMaxHeight().background(Color(0xFFFF0404)))
                Box(modifier = Modifier.weight(1f).fillMaxHeight().background(Color(0xFF0496FF)))
            }
        }
    }
}

// Secciones como "Descripción", "Actores", "Plataforma"
@Composable
fun SectionTitleWithBar(title: String) {
    var textWidth by remember { mutableStateOf(0) }
    val density = LocalDensity.current

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.onGloballyPositioned {
                textWidth = it.size.width
            }
        )
        Spacer(modifier = Modifier.height(4.dp))
        if (textWidth > 0) {
            Row(
                modifier = Modifier
                    .width(with(density) { textWidth.toDp() })
                    .height(4.dp)
            ) {
                Box(modifier = Modifier.weight(1f).fillMaxHeight().background(Color(0xFFFF0404)))
                Box(modifier = Modifier.weight(1f).fillMaxHeight().background(Color(0xFF0496FF)))
            }
        }
    }
}
