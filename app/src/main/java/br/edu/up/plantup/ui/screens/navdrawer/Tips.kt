package br.edu.up.plantup.ui.screens.navdrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.plantup.ui.theme.Preto
import br.edu.up.plantup.ui.screens.visualbar.BottomBar
import br.edu.up.plantup.ui.screens.visualbar.TopBar

val VerdeEscuro = Color(0xFF00712D)
val VerdeClaro = Color(0xFFD5ED9F)
val OffWhite = Color(0xFFFFFBE6)

data class Dica(val titulo: String, val descricao: String)

@Composable
fun Tips(drawerState: DrawerState, navControllerBottomNav: NavController) {
    val dicas = listOf(
        Dica(titulo = "Regar as plantas corretamente", descricao = "Evite regar as plantas em excesso. Molhe apenas quando o solo estiver seco ao toque."),
        Dica(titulo = "Luz adequada", descricao = "Coloque as plantas em locais que recebam luz natural adequada, mas evite exposição direta ao sol para plantas de sombra."),
        Dica(titulo = "Adubação periódica", descricao = "Use adubo orgânico ou químico a cada 15 dias para manter as plantas saudáveis."),
        Dica(titulo = "Limpeza das folhas", descricao = "Remova poeira e sujeira das folhas usando um pano úmido para melhorar a absorção de luz."),
        Dica(titulo = "Vasos adequados", descricao = "Certifique-se de que o vaso tem boa drenagem para evitar o apodrecimento das raízes.")
    )

    Scaffold(
        topBar = { TopBar(drawerState) },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(OffWhite),
                verticalArrangement = Arrangement.spacedBy(30.dp),
                horizontalAlignment = Alignment.Start
            ) {

                items(dicas) { dica ->
                    DicaCard(dica = dica)
                }
            }
        },
        bottomBar = { BottomBar(navControllerBottomNav) }
    )
}

@Composable
fun DicaCard(dica: Dica) {
    Card(
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 5.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = VerdeClaro),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 20.dp, horizontal = 25.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = dica.titulo,
                fontSize = 25.sp,
                color = VerdeEscuro
            )
            Text(
                text = dica.descricao,
                fontSize = 20.sp,
                color = Preto,
                modifier = Modifier.padding(top = 12.dp)
            )
        }
    }
}
