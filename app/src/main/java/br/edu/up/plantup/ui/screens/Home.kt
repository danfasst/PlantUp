package br.edu.up.plantup.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.plantup.PlantUpRoutes
import br.edu.up.plantup.data.ReminderViewModel
import br.edu.up.plantup.ui.screens.visualbar.BottomBar
import br.edu.up.plantup.ui.screens.visualbar.TopBar
import kotlinx.coroutines.launch

@Composable
fun Home(
    drawerState: DrawerState,
    viewModel: ReminderViewModel,
    navController: NavController,
) {

    val coroutineScope = rememberCoroutineScope()
    val reminders by viewModel.reminders.collectAsState()

    Scaffold(

        topBar = { TopBar(drawerState) },
        bottomBar = { BottomBar(navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier.padding(
                    top = 90.dp,
                    start = 30.dp,
                    end = 30.dp,
                    bottom = 30.dp
                ).padding(paddingValues)
            ) {
                Spacer(modifier = Modifier.height(30.dp))

                for (reminder in reminders) {
                    Row {
                        Text(
                            text = reminder.title,
                            fontSize = 30.sp
                        )

                        Button(onClick = {
                            navController.navigate("editReminder/${reminder.id}")
                        }) {
                            Text(text = "Editar", fontSize = 25.sp)
                        }

                        Button(onClick = {
                            coroutineScope.launch {
                                viewModel.remove(reminder)
                            }
                        }) {
                            Text(text = "Concluir", fontSize = 25.sp)
                        }
                    }
                }

                Button(onClick = {
                    navController.navigate(PlantUpRoutes.SCREEN_NEW_REMINDER_ROUTE)
                }) {
                    Text(text = "Adicionar")
                }
            }
        }
    )
}