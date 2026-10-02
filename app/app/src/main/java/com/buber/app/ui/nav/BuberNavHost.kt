package com.buber.app.ui.nav

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.buber.app.ui.screens.*
import com.buber.app.ui.theme.Gray100

private enum class Tab(val route: String, val label: String, val icon: ImageVector) {
    Map("mapa", "Mapa", Icons.Default.Map),
    Lines("linhas", "Linhas", Icons.Default.DirectionsBus),
    Favorites("favoritos", "Favoritos", Icons.Default.Star),
    Profile("conta", "Conta", Icons.Default.Person),
}

@Composable
fun BuberNavHost() {
    val nav = rememberNavController()
    val current by nav.currentBackStackEntryAsState()
    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
                Tab.entries.forEach { tab ->
                    NavigationBarItem(
                        selected = current?.destination?.route == tab.route,
                        onClick = {
                            nav.navigate(tab.route) {
                                popUpTo(nav.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { androidx.compose.material3.Icon(tab.icon, tab.label) },
                        label = { Text(tab.label) },
                        colors = NavigationBarItemDefaults.colors(indicatorColor = Gray100),
                    )
                }
            }
        },
    ) { padding ->
        NavHost(nav, startDestination = Tab.Map.route, modifier = Modifier.padding(padding)) {
            composable(Tab.Map.route) { MapScreen() }
            composable(Tab.Lines.route) { LinesScreen() }
            composable(Tab.Favorites.route) { FavoritesScreen() }
            composable(Tab.Profile.route) { ProfileScreen() }
        }
    }
}
