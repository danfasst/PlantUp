package br.edu.up.plantup.ui.screens.navdrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import br.edu.up.plantup.PlantUpRoutes
import br.edu.up.plantup.R

@Composable
fun DrawerContent(navControllerDrawer: NavHostController, drawerState: DrawerState) {

    val currentBack by navControllerDrawer.currentBackStackEntryAsState()
    val actualRoute = currentBack?.destination?.route ?: PlantUpRoutes.SCREEN_HOME_ROUTE

    val coroutineScope = rememberCoroutineScope()

    val routeTips = actualRoute == PlantUpRoutes.SCREEN_TIPS_ROUTE
    val routeInfo = actualRoute == PlantUpRoutes.SCREEN_INFO_ROUTE

    Column(
        modifier = Modifier
            .width(250.dp)
            .background(br.edu.up.plantup.ui.theme.OffWhite)
            .padding(10.dp, 50.dp)
            .fillMaxHeight()
    ) {

        IconsNavDrawer(
            navControllerDrawer = navControllerDrawer,
            coroutineScope = coroutineScope,
            drawerState = drawerState,
            text = "Dicas",
            route = routeTips,
            icon = R.drawable.leaf,
            navigate = PlantUpRoutes.SCREEN_TIPS_ROUTE
        )

        IconsNavDrawer(
            navControllerDrawer = navControllerDrawer,
            coroutineScope = coroutineScope,
            drawerState = drawerState,
            text = "Informações",
            route = routeInfo,
            icon = R.drawable.leaf,
            navigate = PlantUpRoutes.SCREEN_INFO_ROUTE
        )
    }
}