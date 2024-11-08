package br.edu.up.plantup.ui.screens.visualbar

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import br.edu.up.plantup.PlantUpRoutes
import br.edu.up.plantup.ui.theme.OffWhite
import br.edu.up.plantup.ui.theme.VerdeEscuro

@Composable
fun BottomBar(navController: NavController) {

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    NavigationBar(containerColor = VerdeEscuro) {

        NavigationBarItem(
            selected = currentRoute == PlantUpRoutes.SCREEN_HOME_ROUTE,
            onClick = {
                navController.navigate(PlantUpRoutes.SCREEN_HOME_ROUTE)
            },
            label = { Text("Home", color = OffWhite) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    modifier = iconSize,
                    contentDescription = "Home"
                )
            }
        )

        NavigationBarItem(
            selected = currentRoute == PlantUpRoutes.SCREEN_NEW_REMINDER_ROUTE,
            onClick = {
                navController.navigate(PlantUpRoutes.SCREEN_NEW_REMINDER_ROUTE)
            },
            label = { Text("Lembrete", color = OffWhite) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Check,
                    modifier = iconSize,
                    contentDescription = "Lembrete"
                )
            }
        )

        NavigationBarItem(
            selected = currentRoute == PlantUpRoutes.SCREEN_PROFILE_ROUTE,
            onClick = {
                navController.navigate(PlantUpRoutes.SCREEN_PROFILE_ROUTE)
            },
            label = { Text("Conta", color = OffWhite) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    modifier = iconSize,
                    contentDescription = "Conta"
                )
            }
        )
    }
}

val iconSize = Modifier.size(30.dp)
