package br.edu.up.plantup

import android.provider.ContactsContract.Profile
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.edu.up.plantup.ui.theme.OffWhite
import br.edu.up.plantup.ui.theme.VerdeClaro
import br.edu.up.plantup.ui.theme.VerdeEscuro
import br.edu.up.plantup.ui.theme.screens.Home
import br.edu.up.plantup.ui.theme.screens.Reminder
import br.edu.up.plantup.ui.theme.screens.UserProfile
import br.edu.up.plantup.ui.theme.screens.navdrawer.Info
import br.edu.up.plantup.ui.theme.screens.navdrawer.Tips
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

object PlantUpRoutes {
    val SCREEN_HOME_ROUTE = "home screen"
    val SCREEN_INFO_ROUTE = "info screen"
    val SCREEN_TIPS_ROUTE = "tips screen"
    val SCREEN_REMINDER_ROUTE = "reminder screen"
    val SCREEN_PROFILE_ROUTE = "profile screen"
}

@Preview
@Composable
fun PlantUpNavDrawer() {

    val navControllerDrawer = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerContent = {
            DrawerContent(navControllerDrawer, drawerState)
        },
        drawerState = drawerState,
        content = {
            NavHost(
                navController = navControllerDrawer,
                startDestination = PlantUpRoutes.SCREEN_HOME_ROUTE
            ) {
                composable(PlantUpRoutes.SCREEN_HOME_ROUTE) {
                    Home (drawerState, navControllerDrawer)
                }
                composable(PlantUpRoutes.SCREEN_INFO_ROUTE) {
                    Info (drawerState, navControllerDrawer)
                }
                composable(PlantUpRoutes.SCREEN_TIPS_ROUTE) {
                    Tips (drawerState, navControllerDrawer)
                }
                composable(PlantUpRoutes.SCREEN_REMINDER_ROUTE) {
                    Reminder (drawerState, navControllerDrawer)
                }
                composable(PlantUpRoutes.SCREEN_PROFILE_ROUTE) {
                    UserProfile (drawerState, navControllerDrawer)
                }
            }
        }
    )
}

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
            .background(OffWhite)
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

@Composable
fun IconsNavDrawer(
    navControllerDrawer: NavHostController,
    coroutineScope: CoroutineScope,
    drawerState: DrawerState,
    text: String,
    route: Boolean,
    icon: Int,
    navigate: String
) {
    TextButton(
        onClick = {
            navControllerDrawer.navigate(navigate)
            coroutineScope.launch { drawerState.close() }
        },
        colors = ButtonDefaults.buttonColors(containerColor = getColorMenu(route))
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = "",
            modifier = Modifier.size(40.dp),
            tint = getColorTexto(route)
        )
        Text(
            text,
            fontSize = 28.sp,
            color = getColorTexto(route)
        )
        Spacer(modifier = Modifier.height(50.dp))
    }
}

fun getColorTexto(selected: Boolean): androidx.compose.ui.graphics.Color {

    if (selected) {
        return VerdeEscuro
    }
    return VerdeClaro
}

fun getColorMenu(selected: Boolean): androidx.compose.ui.graphics.Color {

    if (selected) {
        return VerdeClaro
    }
    return OffWhite
}
