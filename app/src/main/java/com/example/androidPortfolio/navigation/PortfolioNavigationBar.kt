package com.example.androidPortfolio.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Extension
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState


data class TopLevelDestination(
    val label: String,
    val destination: Any,
    val icon: ImageVector
)

private val topLevelDestinations = listOf(

    TopLevelDestination(
        label = "Home",
        destination = Home,
        icon = Icons.Default.Home
    ),
    TopLevelDestination(
        label = "About",
        destination = About,
        icon = Icons.Default.Info
    ),
    TopLevelDestination(
        label = "Mini Apps",
        destination = MiniApps,
        icon = Icons.Default.Apps
    ),
    TopLevelDestination(
        label = "Components",
        destination = Components,
        icon = Icons.Default.Extension
    ),
    TopLevelDestination(
        label = "Concepts",
        destination = OtherConcepts,
        icon = Icons.Default.MenuBook
    )
)


@Composable
fun PortfolioNavigationBar(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar (
        containerColor = MaterialTheme.colorScheme.secondaryContainer
    ) {
        topLevelDestinations.forEach { destination ->
            NavigationBarItem(
                icon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = destination.icon,
                        contentDescription = destination.label,
                        tint = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                },

                label = {
                    Text(destination.label)
                },

                selected = currentDestination
                    ?.hierarchy
                    ?.any {
                        it.hasRoute(
                            destination.destination::class
                        )
                    } == true,

                onClick = {
                    navController.navigate(
                        destination.destination
                    ) {
                        popUpTo(
                            navController.graph.findStartDestination().id
                        ) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}