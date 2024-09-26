package br.edu.up.plantup.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.plantup.ui.theme.Laranja
import br.edu.up.plantup.ui.theme.OffWhite
import br.edu.up.plantup.ui.theme.VerdeClaro
import br.edu.up.plantup.ui.theme.VerdeEscuro
import br.edu.up.plantup.ui.theme.screens.visualbar.BottomBar
import br.edu.up.plantup.ui.theme.screens.visualbar.TopBar

data class Lembrete(
    val titulo: String,
    val descricao: String,
    val id: Int,
    var concluido: Boolean = false
)

@Composable
fun Reminder(
    drawerState: DrawerState,
    navControllerBottomNav: NavController
) {
    var lembretes by remember { mutableStateOf(listOf(
        Lembrete(titulo = "Regar a planta", descricao = "Regar as plantas da sala", id = 1),
        Lembrete(titulo = "Adubar", descricao = "Adubar as plantas do jardim", id = 2),
        Lembrete(titulo = "Podar", descricao = "Podar as plantas da varanda", id = 3),
        Lembrete(titulo = "Verificar umidade do solo", descricao = "Checar se o solo das plantas está úmido antes de regar.", id = 4),
        Lembrete(titulo = "Limpar as folhas", descricao = "Remover poeira das folhas das plantas para melhorar a fotossíntese.", id = 5),
        Lembrete(titulo = "Replantar mudas", descricao = "Transplantar as mudas que cresceram demais para vasos maiores.", id = 6),
        Lembrete(titulo = "Fertilizar plantas", descricao = "Adicionar fertilizante às plantas a cada dois meses para um crescimento saudável.", id = 7),
        Lembrete(titulo = "Trocar água do vaso", descricao = "Trocar a água das plantas aquáticas e verificar a saúde das raízes.", id = 8),
        Lembrete(titulo = "Inspecionar pragas", descricao = "Verificar se há sinais de pragas nas plantas e tratar se necessário.", id = 9),
        Lembrete(titulo = "Ajustar luz", descricao = "Mover as plantas para um local com mais luz natural, se necessário.", id = 10)
    )) }

    Scaffold(
        topBar = { TopBar(drawerState) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(OffWhite)
                    .padding(paddingValues)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp, 0.dp),
                    verticalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    items(lembretes) { lembrete ->
                        LembreteButton(lembrete = lembrete) {
                            lembretes = lembretes.map {
                                if (it.id == lembrete.id) it.copy(concluido = !it.concluido) else it
                            }
                        }
                    }
                }
            }
        },
        bottomBar = { BottomBar(navControllerBottomNav) }
    )
}

@Composable
fun LembreteButton(lembrete: Lembrete, onClick: () -> Unit) {

    val backgroundColor = if (lembrete.concluido) VerdeClaro.copy(alpha = 0.3f) else VerdeClaro

    TextButton(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 0.dp),
        colors = ButtonDefaults.textButtonColors(backgroundColor),
        shape = RoundedCornerShape(25.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {
            Text(
                text = lembrete.titulo,
                fontSize = 24.sp,
                color = VerdeEscuro
            )
            Text(
                text = lembrete.descricao,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 8.dp),
                color = VerdeEscuro
            )
        }
    }
}
