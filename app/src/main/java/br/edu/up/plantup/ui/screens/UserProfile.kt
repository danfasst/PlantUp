package br.edu.up.plantup.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.plantup.ui.screens.visualbar.BottomBar
import br.edu.up.plantup.ui.screens.visualbar.TopBar
import br.edu.up.plantup.ui.theme.Laranja
import br.edu.up.plantup.ui.theme.OffWhite
import br.edu.up.plantup.ui.theme.VerdeClaro
import br.edu.up.plantup.ui.theme.VerdeEscuro

@Composable
fun UserProfile(
    drawerState: DrawerState,
    navControllerBottomNav: NavController
) {
    Scaffold(
        topBar = { TopBar(drawerState) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
                    .background(OffWhite),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(35.dp)
            ) {
                ProfileSection()
            }
        },
        bottomBar = { BottomBar(navControllerBottomNav) }
    )
}

@Composable
fun ProfileSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Conta",
            modifier = Modifier
                .size(130.dp)
                .clip(CircleShape)
        )

        Text(
            text = "Geucimar",
            fontSize = 24.sp,
            color = VerdeEscuro
        )
        Text(
            text = "geucimar@gmail.com",
            fontSize = 16.sp,
            color = VerdeEscuro
        )
    }
}
