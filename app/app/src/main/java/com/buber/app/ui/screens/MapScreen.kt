package com.buber.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.buber.app.ui.map.BuberMap
import com.buber.app.ui.theme.Gray100
import com.buber.app.ui.theme.Gray600

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(modifier: Modifier = Modifier) {
    val sheetState = rememberStandardBottomSheetState(initialValue = SheetValue.PartiallyExpanded)
    BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = sheetState),
        sheetPeekHeight = 190.dp,
        sheetContainerColor = MaterialTheme.colorScheme.surface,
        sheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        sheetContent = { NearbySheet() },
    ) { padding ->
        Box(Modifier.fillMaxSize().padding(bottom = padding.calculateBottomPadding())) {
            BuberMap(Modifier.fillMaxSize())
            SearchPill(
                Modifier.align(Alignment.TopCenter).statusBarsPadding()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            )
        }
    }
}

@Composable
private fun SearchPill(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().shadow(8.dp, CircleShape)
            .background(MaterialTheme.colorScheme.surface, CircleShape)
            .clickable { /* Fase 3: abrir busca de linhas/pontos */ }
            .padding(horizontal = 20.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(Icons.Default.Search, null)
        Spacer(Modifier.width(12.dp))
        Text("Para onde?", style = MaterialTheme.typography.titleMedium)
    }
}

@Composable
private fun NearbySheet() {
    Column(Modifier.fillMaxWidth().padding(horizontal = 20.dp).padding(bottom = 24.dp)) {
        Text("Perto de você", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(12.dp))
        listOf("Ônibus ao vivo" to "Em breve (Fase 3)", "Paradas próximas" to "Em breve (Fase 7)").forEach { (t, s) ->
            Row(
                Modifier.fillMaxWidth().padding(vertical = 6.dp)
                    .background(Gray100, RoundedCornerShape(14.dp)).padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(Icons.Default.DirectionsBus, null)
                Spacer(Modifier.width(14.dp))
                Column {
                    Text(t, style = MaterialTheme.typography.titleMedium)
                    Text(s, style = MaterialTheme.typography.bodyMedium, color = Gray600)
                }
            }
        }
    }
}
