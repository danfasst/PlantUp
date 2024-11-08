package br.edu.up.plantup.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.plantup.data.back.Reminder
import br.edu.up.plantup.data.ReminderViewModel
import br.edu.up.plantup.ui.screens.navdrawer.VerdeClaro
import br.edu.up.plantup.ui.screens.navdrawer.VerdeEscuro
import br.edu.up.plantup.ui.screens.visualbar.BottomBar
import br.edu.up.plantup.ui.screens.visualbar.TopBar
import kotlinx.coroutines.launch

@Composable
fun NewReminder(
    reminderId: Int? = null,
    viewModel: ReminderViewModel,
    navController: NavController,
    drawerState : DrawerState
) {

    var coroutineScope = rememberCoroutineScope()

    var title by remember { mutableStateOf("") }
    var day by remember { mutableStateOf("") }
    var hour by remember { mutableStateOf("") }

    var reminder: Reminder? by remember { mutableStateOf(null) }

    var label = if (reminderId == null) "Adicionar Lembrete" else "Editar lembrete"

    LaunchedEffect(reminderId) {
        coroutineScope.launch {
            if (reminderId != null) {
                reminder = viewModel.search(reminderId)
                reminder?.let {
                    title = it.title
                    day = it.day
                    hour = it.hour
                }
            }
        }
    }

    Scaffold(

        topBar = { TopBar(drawerState) },
        bottomBar = { BottomBar(navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize().padding(paddingValues)
                    .background(VerdeClaro)
                    .padding(16.dp)

            ) {
                Text(
                    text = label,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Título") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = day,
                    onValueChange = { day = it },
                    label = { Text("Dia") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = hour,
                    onValueChange = { hour = it },
                    label = { Text("Hora") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = {
                        coroutineScope.launch {
                            val reminder = Reminder(
                                id = reminderId,
                                title = title,
                                day = day,
                                hour = hour
                            )
                            viewModel.add(reminder)
                            navController.popBackStack()
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = VerdeEscuro)
                ) {
                    Text(text = "Salvar", fontSize = 30.sp)
                }
            }
        }
    )
}

