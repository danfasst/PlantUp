package br.edu.up.plantup

import br.edu.up.plantup.ui.theme.screens.Home
import br.edu.up.plantup.ui.screens.NewReminder
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.up.plantup.data.ReminderViewModel
import br.edu.up.plantup.ui.screens.navdrawer.DrawerContent
import br.edu.up.plantup.ui.screens.navdrawer.Info
import br.edu.up.plantup.ui.screens.navdrawer.Tips
import br.edu.up.plantup.ui.theme.screens.UserProfile

object PlantUpRoutes {
    val SCREEN_HOME_ROUTE = "home screen"
    val SCREEN_INFO_ROUTE = "info screen"
    val SCREEN_TIPS_ROUTE = "tips screen"
    val SCREEN_NEW_REMINDER_ROUTE = "add screen"
    val SCREEN_PROFILE_ROUTE = "profile screen"
}

@Composable
fun PlantUpNavigation(viewModel: ReminderViewModel) {

    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerContent = {
            DrawerContent(navController, drawerState)
        },
        drawerState = drawerState,
        content = {
            NavHost(
                navController = navController,
                startDestination = PlantUpRoutes.SCREEN_HOME_ROUTE
            ) {
                composable(PlantUpRoutes.SCREEN_HOME_ROUTE) {
                    Home (drawerState, viewModel, navController)
                }
                composable(PlantUpRoutes.SCREEN_INFO_ROUTE) {
                    Info (drawerState, navController)
                }
                composable(PlantUpRoutes.SCREEN_TIPS_ROUTE) {
                    Tips (drawerState, navController)
                }
                composable("editReminder/{reminderId}") { navRequest ->
                    val reminderId = navRequest.arguments?.getString("reminderId")
                    NewReminder(reminderId?.toInt(), viewModel, navController, drawerState)
                }
                composable(PlantUpRoutes.SCREEN_NEW_REMINDER_ROUTE) {
                    NewReminder(drawerState = drawerState, viewModel = viewModel, navController = navController)
                }
                composable(PlantUpRoutes.SCREEN_PROFILE_ROUTE) {
                    UserProfile (drawerState, navController)
                }
            }
        }
    )
}