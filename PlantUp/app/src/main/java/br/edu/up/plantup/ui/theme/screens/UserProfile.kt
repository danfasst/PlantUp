package br.edu.up.plantup.ui.theme.screens

import android.graphics.Paint.Align
import android.widget.Button
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
import br.edu.up.plantup.ui.theme.Laranja
import br.edu.up.plantup.ui.theme.OffWhite
import br.edu.up.plantup.ui.theme.VerdeClaro
import br.edu.up.plantup.ui.theme.VerdeEscuro
import br.edu.up.plantup.ui.theme.screens.visualbar.BottomBar
import br.edu.up.plantup.ui.theme.screens.visualbar.TopBar

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

                ConfigSection()

                NotificationAndThemeSection()
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

@Composable
fun ConfigSection() {
    Row {
        ConfigItem("Alterar Email")
        ConfigItem("Alterar Senha")
    }
}

@Composable
fun NotificationAndThemeSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        SwitchItem("Notificações Ativadas")
        SwitchItem("Tema Escuro")
    }
}

@Composable
fun ConfigItem(title: String) {


    Card(
        modifier = Modifier
            .padding(12.dp)
            .size(140.dp, 40.dp),
        colors = CardDefaults.cardColors(containerColor = VerdeClaro),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        TextButton(
            modifier = Modifier.fillMaxSize(),
            onClick = { }
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                color = VerdeEscuro
            )
        }
    }
}

@Composable
fun SwitchItem(title: String) {

    val isChecked = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            color = VerdeEscuro
        )
        Switch(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it },  // Altera o valor do estado
            colors = SwitchDefaults.colors(
                checkedThumbColor = VerdeEscuro,
                uncheckedThumbColor = Laranja,
                checkedTrackColor = VerdeClaro,
                uncheckedTrackColor = OffWhite
            )
        )
    }
}