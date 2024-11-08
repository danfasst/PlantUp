package br.edu.up.plantup.ui.screens.navdrawer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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
        return br.edu.up.plantup.ui.theme.VerdeEscuro
    }
    return br.edu.up.plantup.ui.theme.VerdeClaro
}

fun getColorMenu(selected: Boolean): androidx.compose.ui.graphics.Color {

    if (selected) {
        return br.edu.up.plantup.ui.theme.VerdeClaro
    }
    return br.edu.up.plantup.ui.theme.OffWhite
}
