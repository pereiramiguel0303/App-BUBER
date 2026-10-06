package com.buber.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.buber.app.ui.theme.Gray600

@Composable
private fun Placeholder(title: String, subtitle: String, modifier: Modifier) {
    Column(
        modifier.fillMaxSize().statusBarsPadding().padding(24.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        Text(title, style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(8.dp))
        Text(subtitle, style = MaterialTheme.typography.bodyLarge, color = Gray600)
    }
}

@Composable fun LinesScreen(modifier: Modifier = Modifier) =
    Placeholder("Linhas", "Lista de linhas e horários (Fases 3 e 6).", modifier)

@Composable fun FavoritesScreen(modifier: Modifier = Modifier) =
    Placeholder("Favoritos", "Linhas e paradas salvas (Fase 7).", modifier)

@Composable fun ProfileScreen(modifier: Modifier = Modifier) =
    Placeholder("Conta", "Login e preferências (Fase 2).", modifier)
